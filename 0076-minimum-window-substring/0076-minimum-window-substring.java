class Solution {
    public String minWindow(String s, String t) {
        int slen = s.length();
        int tlen = t.length();
        if (slen < tlen) {
            return "";
        }

        // 투 포인터 (슬라이딩 윈도우)
        // 카운트용 map 활용 연습 (배열도 무방)
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < tlen; i++) {
            char c = t.charAt(i);
            map.put(c, (map.getOrDefault(c, 0) + 1)); // 필요 개수 저장
        }

        int st = 0; // 시작 포인터
        int tmp = 0; // 최소 길이 시작점 저장
        int len = Integer.MAX_VALUE; // 현재 길이 (최소값 도출)
        int cnt = 0; // 조건 충족한 총 글자 수

        // [1] ed(끝 포인터) 이동하며 윈도우 탐색
        for (int ed = 0; ed < slen; ed++) {
            char curr = s.charAt(ed);
            if (map.containsKey(curr)) {
                // [2] 중복 초과가 아닐 경우: 카운트 증가
                if (map.get(curr) > 0) {
                    cnt++;
                }
                map.put(curr, (map.get(curr) - 1)); // 초과 시 음수로 표현
            }

            // [3] t 모두 포함: st 이동 (최소 길이 탐색)
            while (cnt == tlen) {
                // 최소 길이 갱신
                if ((ed - st + 1) < len) {
                    len = Math.min((ed - st + 1), len);
                    tmp = st; // 시작점 갱신
                }

                // 현재 글자에 따라 카운트 갱신
                char stcurr = s.charAt(st);
                if (map.containsKey(stcurr)) {
                    map.put(stcurr, (map.get(stcurr) + 1));
                    // [4] map 값 양수 = 글자 부족: 카운트 감소
                    // = 조건 충족한 글자 수 다시 감소
                    if (map.get(stcurr) > 0) {
                        cnt--;
                    }
                }
                st++; // 시작 포인터 이동
            }
        }
        // string 변수 갱신은 비효율적
        // substring으로 바로 반환
        return (len == Integer.MAX_VALUE) ? "" : s.substring(tmp, tmp + len);
    }
}
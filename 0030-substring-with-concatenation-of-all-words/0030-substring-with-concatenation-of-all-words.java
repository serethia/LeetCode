class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        // words 길이 일정: 슬라이딩 윈도우 & 해시맵 2개
        int w = words[0].length(); // 각 단어 길이
        List<Integer> indices = new ArrayList<>(); // 반환할 인덱스 리스트
        
        // 필요한 기존 words의 각 중복 횟수 (고정)
    Map<String, Integer> need = new HashMap<>();
    for(int i = 0; i < words.length; i++){
        // put(key, value)
        // getordefault(key 있을 때 그 value, 없을 때 반환할 기본값)
        need.put(words[i], (need.getOrDefault(words[i], 0) + 1));
        
    }
        // 현재 words의 각 중복 횟수 (가변)
        for(int i = 0; i < w; i++){
            Map<String, Integer> curr = new HashMap<>();
            int st = i; // 시작 인덱스
int cnt = 0; // 앞으로 세어 갈 카운트
            // 각 단어 크기 일정: ed가 w만큼 뛰어 넘을 수 있게 됨
            for(int ed = i; ed + w <= s.length(); ed += w){
                String str = s.substring(ed, ed + w); // 원본 string을 words 요소 크기만큼 잘라 비교
                if(need.containsKey(str)){
                    // key가 있으면 현재 카운트 증가
                    cnt++;
                    curr.put(str, (curr.getOrDefault(str, 0) + 1)); // need처럼 키의 값 or 기본값 0에 카운트 1 증가
                    // 총 필요 개수를 넘어가면 while로 그 key의 현재 카운트를 1 줄이고 맨 앞 중복 단어를 제거
                    while(need.get(str) < curr.get(str)){
                        
                cnt--; // 현재 카운트 원래대로 돌려 놓기
                        curr.put(s.substring(st, st + w), (curr.get(s.substring(st, st + w)) - 1));
                        st = st + w; // 시작 인덱스 이동 (다음 단어로)
                    }
                    // 만족하는 총 단어 수가 필요한 총 단어 수와 일치: 리스트에 시작 인덱스 추가 (equals 함수는 비효율적)
                if(cnt == words.length){
                    indices.add(st);
                }
                } else {
                    // key가 없으면 카운트 초기화
                    cnt = 0;
                    st = ed + w; // 시작점 이동
                    curr.clear(); // 현재 카운트 map 비우기
                }
            }

        }


        return indices;
    }
}
class Solution {
    public boolean isAnagram(String s, String t) {
        // 글자 수 다르면 F
        // length()만 비교 => 유니코드 대응 코드로 수정
        // codePointCount(시작idx,미포함끝idx)
        if (s.codePointCount(0, s.length()) != t.codePointCount(0, t.length())) {
            return false;
        }

        // charAt(): 유니코드 대응 못함
        // 키: 코드포인트, 값: 카운트
        // codePointAt(idx): 해당 idx의 codepoint 반환
        // Character.charCount(codepoint):
        // codepoint가 차지하는 char 칸수 반환
        // for문 i 증감은 내부에서 따로 이동
        Map<Integer, Integer> scnt = new HashMap<>();
        for (int i = 0; i < s.length();) {
            int scurr = s.codePointAt(i);
            scnt.put(scurr, scnt.getOrDefault(scurr, 0) + 1);
            i += Character.charCount(scurr);
        }
        Map<Integer, Integer> tcnt = new HashMap<>();
        for (int i = 0; i < t.length();) {
            int tcurr = t.codePointAt(i);
            tcnt.put(tcurr, tcnt.getOrDefault(tcurr, 0) + 1);
            i += Character.charCount(tcurr);
        }

        // 맵 일치 여부 반환
        return scnt.equals(tcnt);
    }
}
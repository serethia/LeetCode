class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        // ransomNote가 magazine에 포함되면 true: hashMap 활용
        // (ransomNote에서 곧바로 char 비교해도 무방)
        // (배열에서 'a'를 빼는 방식도 무방)
        // 복잡도 효율보다는 map 함수를 연습해보기로 함
        Map<Character, Integer> r = new HashMap<>();
        for (int i = 0; i < ransomNote.length(); i++) {
            char c = ransomNote.charAt(i);
            // 해당 글자와 그 글자의 누적 개수
            r.put(c, r.getOrDefault(c, 0) + 1);
        }
        Map<Character, Integer> m = new HashMap<>();
        for (int i = 0; i < magazine.length(); i++) {
            char c = magazine.charAt(i);
            // 해당 글자와 그 글자의 누적 개수
            m.put(c, m.getOrDefault(c, 0) + 1);
        }

        // m.entrySet().containsAll(r.entrySet())
        // 는 정확히 일치할 때만: 일부 테스트케이스 틀림
        // keySet 함수: null 제외하고 루프
        for (char each : r.keySet()) {
            // magazine에 들어있는 요소 개수가 
            // ransomNote 요소 개수 "이상"이어야 T
            if (m.getOrDefault(each, 0) < r.get(each)) {
                return false;
            }
        }
        return true;
    }
}
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // 알파벳 소문자 only = 빈도수 배열로도 가능
        // 키: anagram 가능한 문자 조합
        // 값: anagram 경우의 수를 담은 리스트
        Map<String, List<String>> ag = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {
            String s = strs[i]; // 정렬 전 (value)
            // char 오름차순으로 정렬
            char[] schar = s.toCharArray();
            Arrays.sort(schar);
            // new String(char[]): char[] 연결한 문자열 생성자
            String str = new String(schar); // 정렬 후 (key)

            if (!ag.containsKey(str)) {
                // 새 리스트에 추가
                List<String> l = new ArrayList<>();
                l.add(s);
                ag.put(str, l);
            } else {
                // 기존 리스트에 추가
                ag.get(str).add(s);
            }
        }

        // ag를 함수의 반환 형태로 return
        // map.values(): 맵의 값들만 가져옴
        return new ArrayList<>(ag.values());
    }
}
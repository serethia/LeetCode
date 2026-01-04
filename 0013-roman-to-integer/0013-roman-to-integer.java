class Solution {
    public int romanToInt(String s) {
        // 로마자와 값 지정
        Map<Character, Integer> map = new HashMap<>() {
            {
                put('I', 1);
                put('V', 5);
                put('X', 10);
                put('L', 50);
                put('C', 100);
                put('D', 500);
                put('M', 1000);
            }
        };
        int len = s.length();
        int val = map.get(s.charAt(len - 1));

        // 오른쪽에서 탐색 시작 (앞의 값이 더 작다면 뺄 것)
        for (int i = len - 2; i >= 0; i--) {
            if (map.get(s.charAt(i)) >= map.get(s.charAt(i + 1))) {
                val += map.get(s.charAt(i));
            } else {
                val -= map.get(s.charAt(i));
            }
        }

        return val;
    }
}
class Solution {
    public int lengthOfLastWord(String s) {
        // s.trim().split(" ", -1);는 연속 공백 못 지움 = 인덱스로 직접 접근해야 함
        int len = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                if (len > 0) {
                    break;
                } else {
                    continue;
                }
            } else {
                len++;
            }
        }
        return len;
    }
}
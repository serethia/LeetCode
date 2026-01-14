class Solution {
    public boolean isPalindrome(String s) {
        int len = s.length();
        // 길이 0: true
        if (s.isEmpty()) {
            return true;
        } else {
            // 투 포인터 (숫자 ASCII 포함)
            int left = 0;
            int right = len - 1;
            // 포인터끼리 만날 때까지
            while (left <= right) {
                char l = s.charAt(left);
                char r = s.charAt(right);
                // 알파벳이나 숫자가 아니면 해당 포인터 이동
                if (!Character.isLetterOrDigit(l)) {
                    left++;
                } else if (!Character.isLetterOrDigit(r)) {
                    right--;
                } else {
                    // 알파벳은 소문자로 통일해 비교
                    if (Character.toLowerCase(l) != Character.toLowerCase(r)) {
                        return false;
                    } else {
                        // 같다면 양쪽 포인터 동시 이동
                        left++;
                        right--;
                    }
                }
            }
            return true;
        }
    }
}
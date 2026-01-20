class Solution {
    public int lengthOfLongestSubstring(String s) {
        // 투 포인터 & set 중복 제거 (큐보다 효율적)
        int st = 0;
        int ed = 0;
        Set<Character> set = new HashSet<>();
        int len = 0; // set 크기로 최대 길이 계산
        while (ed < s.length()) {
            char letter = s.charAt(ed);
            if (set.contains(letter)) {
                while (s.charAt(st) != letter && st < ed) {
                    char duplicate = s.charAt(st);
                    set.remove(duplicate);
                    st++;
                }
                set.remove(s.charAt(st));
                st++;
            }
            set.add(letter);
            ed++;
            len = Math.max(set.size(), len);
        }
        return len;
    }
}
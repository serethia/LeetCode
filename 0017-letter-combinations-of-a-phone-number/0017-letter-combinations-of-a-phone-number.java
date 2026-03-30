class Solution {
    String[] phone = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" }; // 인덱스 번호 = 전화 번호 (0~9)
    List<String> l; // 반환 리스트

    public List<String> letterCombinations(String digits) {
        l = new ArrayList<>();
        find(digits, 0, new StringBuilder());
        return l;
    }

    private void find(String d, int idx, StringBuilder sb) {
        if (idx >= d.length()) {
            l.add(sb.toString());
            return;
        }

        String str = phone[d.charAt(idx) - '0'];
        for (int i = 0; i < str.length(); i++) {
            sb.append(str.charAt(i)); // 추가
            find(d, idx + 1, sb); // 다음 글자
            sb.deleteCharAt(sb.length() - 1); // 마지막 제거 (복구)
        }
    }
}
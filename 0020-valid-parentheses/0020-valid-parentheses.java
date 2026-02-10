class Solution {
    public boolean isValid(String s) {
        // 홀수 개면 F
        if (s.length() % 2 == 1) {
            return false;
        }

        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!st.isEmpty() && c == ')' && st.peek() == '(') {
                st.pop();
            } else if (!st.isEmpty() && c == '}' && st.peek() == '{') {
                st.pop();
            } else if (!st.isEmpty() && c == ']' && st.peek() == '[') {
                st.pop();
            } else {
                st.push(c);
            }
        }
        return st.isEmpty();
    }
}
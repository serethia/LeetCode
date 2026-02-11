class Solution {
    public String simplifyPath(String path) {
        Stack<String> st = new Stack<>();
        String[] dir = path.split("/");
        for (int i = 0; i < dir.length; i++) {
            String s = dir[i];
            // 여러 if문은 예외 조건부터 작성
            if (s.equals("..")) {
                // ".."인지 체크하고 pop 확인해야
                // 처음이 ".."인 경우도 있음
                if (!st.isEmpty()) {
                    // 이전 디렉토리로: 스택에서 제거
                    st.pop();
                }
            } else if (s.length() > 0 && !s.equals(".")) {
                // "/"가 연속일 때도 제외
                st.push(s);
            }
        }

        // stringbuilder는 스택 거꾸로 저장X => join
        return ("/" + String.join("/", st));
    }
}
class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> num = new Stack();
        for (int i = 0; i < tokens.length; i++) {
            String str = tokens[i];
            // pop한 순서 주의
            if (str.equals("+")) {
                int b = num.pop();
                int a = num.pop();
                num.push(a + b);
            } else if (str.equals("-")) {
                int b = num.pop();
                int a = num.pop();
                num.push(a - b);
            } else if (str.equals("*")) {
                int b = num.pop();
                int a = num.pop();
                num.push(a * b);
            } else if (str.equals("/")) {
                int b = num.pop();
                int a = num.pop();
                num.push(a / b);
            } else {
                num.push(Integer.parseInt(str));
            }
        }
        return num.pop();
    }
}
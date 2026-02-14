class Solution {
    // for문 대신 인스턴스 활용 (static 아님)
    int i;

    // 스택 & 재귀 활용 (괄호 계산마다 호출)
    public int calculate(String s) {
        i = 0;
        return cal(s);
    }

    private int cal(String str) {
        Stack<Integer> stack = new Stack<>();
        int n = 0; // 앞의 값 (여러 자리 수 고려)
        char ex = '+'; // 현재 연산자 부호

        while (i < str.length()) {
            char c = str.charAt(i);
            if (c == ' ') {
                // [1] 공백
                i++;
                continue;
            } else if (c == '+' || c == '-') {
                // [2] 연산자
                if (ex == '+') {
                    stack.push(n);
                } else {
                    stack.push(-n);
                }
                ex = c; // 현재 연산자로 갱신
                n = 0;
            } else if (c == '(') {
                // [3] 괄호 열림 (재귀 호출)
                i++;
                n = cal(str);
            } else if (c == ')') {
                // [4] 괄호 닫힘 (재귀 탈출)
                if (ex == '+') {
                    stack.push(n);
                } else {
                    stack.push(-n);
                }
                break;
                // 마지막 항이 ')'인 경우 
                // i < str.length()일 때 break
            } else {
                // [5] 숫자
                // 여러 자리 수 고려해서 누적하기
                n = (n * 10) + (c - '0');
            }
            i++;
        }

        // 마지막이 ')'가 아닌 숫자일 때 처리
        if (i == str.length()) {
            if (ex == '+') {
                stack.push(n);
            } else {
                stack.push(-n);
            }
        }

        // 스택 내 숫자 모두 합산
        int tot = 0;
        while (!stack.isEmpty()) {
            tot += stack.pop();
        }
        return tot;
    }
}
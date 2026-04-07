class Solution {
    // 괄호 n쌍의 모든 조합
    // 스택 (괄호 검증용) 필요X
    List<String> l;

    public List<String> generateParenthesis(int n) {
        l = new ArrayList<>();
        comb(new StringBuilder(), n, n);
        return l;
    }

    // st: '(' 수, ed: ')' 수
    private void comb(StringBuilder sb, int st, int ed) {
        if (st == 0 && ed == 0) {
            l.add(sb.toString());
            return;
        }

        // '(' 남아있으면 sb에 추가
        if (st > 0) {
            sb.append("(");
            comb(sb, st - 1, ed);
            sb.deleteCharAt(sb.length() - 1); // 원상 복구 (백트래킹)
        }

        // ')'쪽이 많으면 괄호 쌍 완성하기
        if (ed > st) {
            sb.append(")");
            comb(sb, st, ed - 1);
            sb.deleteCharAt(sb.length() - 1); // 원상 복구 (백트래킹)
        }
    }
}
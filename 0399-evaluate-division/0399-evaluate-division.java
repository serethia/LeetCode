class Solution {
    private Map<String, String> p; // 부모 노드 저장 (union-find에서의 루트: 해당 노드가 속한 집합의 맨 위 부모, 고정된 값이 아니라 union에 따라 변함)
    private Map<String, Double> w; // 현재 노드부터 find 함수로 찾은 맨 위 부모 노드까지 가중치를 누적으로 곱한 값 저장

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        // union-find (dfs가 더 비효율적)
        int en = equations.size();
        p = new HashMap<>();
        w = new HashMap<>();
        for (int i = 0; i < en; i++) {
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);

            if (!p.containsKey(a)) {
                p.put(a, a);
                w.put(a, 1.0);
            }
            if (!p.containsKey(b)) {
                p.put(b, b);
                w.put(b, 1.0);
            }
            union(a, b, values[i]);
        }

        int qn = queries.size();
        double[] ans = new double[qn];
        for (int i = 0; i < qn; i++) {
            String A = queries.get(i).get(0);
            String B = queries.get(i).get(1);
            // 노드가 없다면 -1.0 반환
            if (!p.containsKey(A) || !p.containsKey(B)) {
                ans[i] = -1.0;
                continue;
            }

            if (find(A).equals(find(B))) {
                // 같은 집합: 계산한 값 반환
                ans[i] = (w.get(A) / w.get(B));
            } else {
                // 다른 집합: 계산 불가 = -1.0 반환
                ans[i] = -1.0;
            }
        }
        return ans;
    }

    // 부모 노드 탐색 FIND
    private String find(String curr) {
        // 자기 자신이 아니면 맨 위 부모 탐색
        if (!p.get(curr).equals(curr)) {
            String tmp = p.get(curr);
            String pcurr = find(tmp); // 재귀로 탐색
            // [식1] (curr / tmp) = w.get(curr)
            // [식2] (tmp / pcurr) = w.get(tmp)
            // [식3] (curr / pcurr) = (curr / tmp) * (tmp / pcurr) = w에 put할 값
            w.put(curr, (w.get(curr) * w.get(tmp))); // 가중치 누적 곱
            p.put(curr, pcurr); // 부모 연결
        }
        return p.get(curr); // 현재 노드의 (맨 위) 부모 반환
    }

    // 다른 부모를 가진 그래프 그룹끼리 연결 UNION
    private void union(String st, String ed, double val) {
        String s = find(st);
        String e = find(ed);
        // 다른 그룹이면 연결
        if (!s.equals(e)) {
            p.put(s, e); // e가 s의 부모
            // [식1] (st / ed) = val
            // [식2] (st / s) = w.get(st)
            // [식3] (ed / e) = w.get(ed)
            // w에 put할 값 = (s / e) = 맨 위 두 부모 간의 비율
            w.put(s, (val * w.get(ed) / w.get(st))); // 연결한 그래프의 값 저장
        }
    }
}
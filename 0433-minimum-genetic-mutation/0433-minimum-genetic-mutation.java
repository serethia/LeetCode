class Solution {
    // BFS 레벨
    public int minMutation(String startGene, String endGene, String[] bank) {
        // endGene 없다면 -1
        boolean contains = false;
        for (int i = 0; i < bank.length; i++) {
            if (bank[i].equals(endGene)) {
                contains = true;
                break;
            }
        }
        if (!contains) {
            return -1;
        }

        int n = 0; // 최소 변이 횟수
        Queue<String> q = new LinkedList<>();
        q.offer(startGene);
        boolean[] visited = new boolean[bank.length]; // 방문 처리 (set으로 remove해서 방문 처리해도 무방)
        while (!q.isEmpty()) {
            int size = q.size();
            for (int idx = 0; idx < size; idx++) {
                String curr = q.poll();
                if (curr.equals(endGene)) {
                    return n;
                }
                for (int jdx = 0; jdx < bank.length; jdx++) {
                    if (!visited[jdx]) {
                        boolean able = diff(curr, bank[jdx]);
                        if (able) {
                            visited[jdx] = true;
                            q.offer(bank[jdx]);
                        }
                    }
                }
            }
            n++;
        }
        return -1;
    }

    // 글자 차이가 1이면 큐에 추가
    private boolean diff(String s, String t) {
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != t.charAt(i)) {
                cnt++;
            }
        }
        return cnt == 1;
    }
}
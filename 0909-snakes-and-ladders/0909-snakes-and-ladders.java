class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length; // 한 변의 길이
        int goal = (n * n); // 도착 지점

        // BFS 레벨 + cnt
        Queue<Integer> q = new LinkedList<>(); // BFS용 큐
        q.offer(1); // 시작점 값 넣어두기
        boolean[] visited = new boolean[goal + 1]; // 방문 여부 저장
        visited[1] = true; // 방문 체크해두기
        int cnt = 0; // 주사위 던진 최소 횟수

        while (!q.isEmpty()) {
            int s = q.size(); // 레벨
            for (int i = 0; i < s; i++) {
                int curr = q.poll();
                // 도달 시 종료 (cnt 반환)
                if (curr == goal) {
                    return cnt;
                }

                // 주사위 1~6만큼 이동한 곳 nxt 탐색
                for (int d = 1; d <= 6; d++) {
                    int nxt = curr + d;
                    if (nxt > goal) {
                        break;
                    }

                    // nxt(here) 자리가 -1이 아니라면
                    int[] here = coordinates(n, nxt);
                    if (board[here[0]][here[1]] != -1) {
                        // 적혀 있는 값으로 이동
                        nxt = board[here[0]][here[1]];
                    }

                    // 방문 체크
                    if (!visited[nxt]) {
                        visited[nxt] = true;
                        q.offer(nxt);
                    }
                }

            }
            cnt++; // 레벨마다 cnt 추가
        }
        return -1; // 도달 못 할 시 -1 반환
    }

    // nxt(next) 값 자리의 좌표 구하기 (지그재그)
    private int[] coordinates(int l, int next) {
        int r = (l - 1) - ((next - 1) / l); // 아래 => 위
        int c = (next - 1) % l; // 맨 아래 r 기준: 좌 => 우

        // r이 아래에서 m번째라고 할 때,
        // m이 홀수면 c 배치 거꾸로 변환 (지그재그)
        int m = ((l - 1) - r);
        if (m % 2 == 1) {
            c = ((l - 1) - c);
        }
        return new int[] { r, c };
    }
}
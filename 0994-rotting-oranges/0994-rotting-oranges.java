class Solution {
    Queue<int[]> q; // 큐
    int t; // 모두 상할 때까지 걸린 시간
    int[] dr = { -1, 1, 0, 0 }; // 4방향
    int[] dc = { 0, 0, -1, 1 };

    public int orangesRotting(int[][] grid) {
        q = new LinkedList<>();
        t = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                // 상한 곳 모두 큐에 넣기
                if (grid[r][c] == 2) {
                    q.offer(new int[] { r, c });
                }
            }
        }

        bfs(grid); // 탐색

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                // 싱싱한 게 남아 있으면 -1
                if (grid[r][c] == 1) {
                    return -1;
                }
            }
        }

        return t; // 없다면 최소 시간 반환
    }

    private void bfs(int[][] map) {
        while (!q.isEmpty()) {
            int n = q.size();
            boolean rotten = false; // 추가로 상했는지 여부
            for (int i = 0; i < n; i++) {
                int[] curr = q.poll();
                // 상하좌우 싱싱한 곳 탐색
                for (int d = 0; d < 4; d++) {
                    int nr = curr[0] + dr[d];
                    int nc = curr[1] + dc[d];
                    if (nr < 0 || nc < 0 || nr >= map.length || nc >= map[0].length || map[nr][nc] != 1) {
                        // 경계 조건 & 싱싱하지 않으면 루프
                        continue;
                    }
                    // 그 지점을 상하게 함 (방문 체크)
                    map[nr][nc] = 2;
                    q.offer(new int[] { nr, nc });
                    rotten = true;
                }
            }

            if (rotten) {
                t++; // 주변 상했다면 시간 증가
            }
        }
    }
}
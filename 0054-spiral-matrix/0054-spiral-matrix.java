class Solution {
    // 우하좌상 탐색
    static int[] dr = { 0, 1, 0, -1 };
    static int[] dc = { 1, 0, -1, 0 };
    static int m; // 행
    static int n; // 열
    static boolean[][] visited; // 방문 여부
    static List<Integer> spiral; // 반환 리스트

    public List<Integer> spiralOrder(int[][] matrix) {
        m = matrix.length;
        n = matrix[0].length;
        visited = new boolean[m][n];
        spiral = new ArrayList<>();
        order(0, 0, matrix);
        return spiral;
    }

    private void order(int r, int c, int[][] map) {
        int d = 0; // 현재 방향 (인덱스 처리 필요)
        for (int i = 0; i < m * n; i++) {
            // 방문 처리 & 이동한 곳의 값 저장
            visited[r][c] = true;
            spiral.add(map[r][c]);
            // 이동할 좌표 설정
            int nr = r + dr[d % 4];
            int nc = c + dc[d % 4];
            // 경계선 도달 시 방향 전환
            if (nr >= m || nr < 0 || nc >= n || nc < 0 || visited[nr][nc]) {
                d++;
                nr = r + dr[d % 4];
                nc = c + dc[d % 4];
            }
            // 이동
            r = nr;
            c = nc;
        }
    }
}
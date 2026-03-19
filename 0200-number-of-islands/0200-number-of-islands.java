class Solution {
    // 1: 섬, 0: 물
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int num = 0; // 섬의 수
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] - '0' == 1) {
                    num++; // 시작점 찾음
                    find(grid, r, c);
                }
            }
        }
        return num;
    }

    // 어디까지가 섬인지 탐색
    private void find(char[][] map, int row, int col) {
        // 경계선
        if (row < 0 || row >= map.length || col < 0 || col >= map[0].length) {
            return;
        }

        // 4방향 탐색
        if (map[row][col] - '0' == 1) {
            map[row][col] = '2'; // 방문 처리
            find(map, row - 1, col);
            find(map, row + 1, col);
            find(map, row, col - 1);
            find(map, row, col + 1);
        }
    }
}
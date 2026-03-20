class Solution {
    // 'X'에 완벽하게 둘러싸인 'O'를 'X'로 변경
    // = 테두리에서 시작하는 'O' 제외 = 'V'로 바꾸자
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        // row 테두리 전부 'V'로 visited 처리
        for (int c = 0; c < n; c++) {
            find(board, 0, c);
            find(board, m - 1, c);
        }
        // col 테두리 전부 'V'로 visited 처리
        for (int r = 0; r < m; r++) {
            find(board, r, 0);
            find(board, r, n - 1);
        }

        // 2차원 배열 값 갱신
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (board[r][c] == 'O') {
                    board[r][c] = 'X'; // 변경
                } else if (board[r][c] == 'V') {
                    board[r][c] = 'O'; // 원상복귀
                }
            }
        }
    }

    // 테두리 'O' 영역 찾기
    private void find(char[][] map, int row, int col) {
        if (row < 0 || row >= map.length || col < 0 || col >= map[0].length || map[row][col] != 'O') {
            return;
        }

        map[row][col] = 'V'; // visited 처리
        find(map, row - 1, col);
        find(map, row + 1, col);
        find(map, row, col - 1);
        find(map, row, col + 1);
    }
}
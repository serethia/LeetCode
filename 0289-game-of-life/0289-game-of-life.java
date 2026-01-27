class Solution {
    // 상 하 좌 우 대각선 8방향 탐색
    static int[] dr = { -1, 1, 0, 0, -1, -1, 1, 1 };
    static int[] dc = { 0, 0, -1, 1, -1, 1, -1, 1 };

    public void gameOfLife(int[][] board) {
        // 1에 이웃한 1이 2~3개: 1, 나머지: 0
        // 0에 이웃한 1이 3개: 1, 나머지: 0
        int m = board.length;
        int n = board[0].length;
        // 원본 배열에서 바로 동시 진행
        // 세대 구분: 홀짝 (N % 2 = 0 or 1)
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                int cnt = 0; // 이웃한 1의 수
                int curr = board[r][c];
                if (curr == 1) {
                    // [1] 1일 때
                    for (int d = 0; d < 8; d++) {
                        int nr = r + dr[d];
                        int nc = c + dc[d];
                        // 경계 조건
                        if (nr < 0 || nr >= m || nc < 0 || nc >= n) {
                            continue;
                        }
                        int near = board[nr][nc];
                        // 현재 생: 카운트 up
                        if (near == 1 || near == 2) {
                            cnt++;
                        }
                    }
                    if (cnt < 2 || cnt > 3) {
                        curr = 2; // 생 => 사: 짝수로 구분
                    }
                    board[r][c] = curr;
                } else {
                    // [2] 0일 때
                    for (int d = 0; d < 8; d++) {
                        int nr = r + dr[d];
                        int nc = c + dc[d];
                        // 경계 조건
                        if (nr < 0 || nr >= m || nc < 0 || nc >= n) {
                            continue;
                        }
                        int near = board[nr][nc];
                        // 현재 생: 카운트 up
                        if (near == 1 || near == 2) {
                            cnt++;
                        }
                    }
                    if (cnt == 3) {
                        curr = 3; // 사 => 생: 홀수로 구분
                    }
                    board[r][c] = curr;
                }
            }
        }

        // 모든 홀짝을 0 or 1로 변환
        // <참고> for(int N : arr) 방식은 값 수정 X, 복사 only
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                board[r][c] %= 2;
            }
        }
    }
}
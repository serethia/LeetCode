class Solution {
    public void rotate(int[][] matrix) {
        // void 반환 시 return;은 보통 생략함
        // 상->우, 우->하, 하->좌, 좌->상 동시에 swap
        int n = matrix[0].length;
        // 정사각형 단위로 (n - 1)칸씩 반복
        for (int r = 0; r < n / 2; r++) {
            for (int c = r; c < n - 1 - r; c++) {
                int top = matrix[r][c]; // 상 저장
                matrix[r][c] = matrix[n - 1 - c][r]; // 상 <= 좌
                matrix[n - 1 - c][r] = matrix[n - 1 - r][n - 1 - c]; // 좌 <= 하
                matrix[n - 1 - r][n - 1 - c] = matrix[c][n - 1 - r]; // 하 <= 우
                matrix[c][n - 1 - r] = top; // 우 <= 상(top)
            }
        }
    }
}
class Solution {
    public void setZeroes(int[][] matrix) {
        // 배열 복사 (X) 
        // 0 위치 따로 기억 (X)
        // 마커 저장소 boolean 활용 (O)
        int m = matrix.length;
        int n = matrix[0].length;

        // ex)
        // 마 커 저 장
        // 커 a b c
        // 저 d e f
        // 장 g h i

        // [1] 첫 행 or 열에 0 있으면 
        // boolean 마커 true 변환
        boolean rowZero = false;
        boolean colZero = false;
        for (int r = 0; r < m; r++) {
            if (matrix[r][0] == 0) {
                rowZero = true;
            }
        }
        for (int c = 0; c < n; c++) {
            if (matrix[0][c] == 0) {
                colZero = true;
            }
        }

        // [2] 나머지 영역에 0 있으면 
        // 그 줄의 첫 행 or 열 0 변환
        for (int r = 1; r < m; r++) {
            for (int c = 1; c < n; c++) {
                if (matrix[r][c] == 0) {
                    matrix[r][0] = 0;
                    matrix[0][c] = 0;
                }
            }
        }

        // [3] 그 줄의 첫 행 or 열에 0 있으면
        // 나머지 영역 0 변환 ([2]의 역과정)
        for (int r = 1; r < m; r++) {
            for (int c = 1; c < n; c++) {
                if (matrix[r][0] == 0 || matrix[0][c] == 0) {
                    matrix[r][c] = 0;
                }
            }
        }

        // [4] boolean 마커 true면 
        // 첫 행 or 열 전부 0 변환 ([1]의 역과정)
        if (rowZero) {
            for (int r = 0; r < m; r++) {
                matrix[r][0] = 0;
            }
        }
        if (colZero) {
            for (int c = 0; c < n; c++) {
                matrix[0][c] = 0;
            }
        }
    }
}
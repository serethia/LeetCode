class Solution {
    // 2차원 배열을 1차원으로 보는 이분 탐색
    // 시간복잡도 O(log(mn)): 전체 원소 mn개여서
    public boolean searchMatrix(int[][] matrix, int target) {
        int st = 0;
        int ed = ((matrix.length) * (matrix[0].length) - 1);
        while (st <= ed) {
            int mid = st + (ed - st) / 2;
            if (matrix[mid / matrix[0].length][mid % matrix[0].length] == target) {
                return true;
            } else if (matrix[mid / matrix[0].length][mid % matrix[0].length] > target) {
                ed = mid - 1;
            } else {
                st = mid + 1;
            }
        }
        return false;
    }
}
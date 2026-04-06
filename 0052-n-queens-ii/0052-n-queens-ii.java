class Solution {
    // 이중 for문보다 boolean[] 쪽이 효율적
    boolean[] ver; // 수직 검사
    boolean[] diaL; // 대각 검사 \ (r-c)
    boolean[] diaR; // 대각 검사 / (r+c)
    int sol; // 가능한 수

    public int totalNQueens(int n) {
        // 방문처리용 배열들 (T: 방문완료)
        ver = new boolean[n];
        diaL = new boolean[n * 2];
        diaR = new boolean[n * 2];
        sol = 0;
        find(0, n); // 수평 검사 필요X
        return sol;
    }

    private void find(int r, int n) {
        // 모든 행 탐색 & 조건 만족했다면 sol+1
        if (r == n) {
            sol++;
            return;
        }

        // 백트래킹
        for (int c = 0; c < n; c++) {
            // 상하좌우대각 안 겹치면 퀸 놓기
            if (!ver[c] && !diaL[(r - c) + n] && !diaR[r + c]) {
                ver[c] = true;
                diaL[(r - c) + n] = true;
                diaR[r + c] = true;
                find(r + 1, n); // 놨으면 다음 행
                ver[c] = false;
                diaL[(r - c) + n] = false;
                diaR[r + c] = false;
            }
        }
    }
}
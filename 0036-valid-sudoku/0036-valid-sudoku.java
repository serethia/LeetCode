class Solution {
    public boolean isValidSudoku(char[][] board) {
        // hashset가 들어갈 배열 만들기
        Set<Character>[] row = new HashSet[9];
        Set<Character>[] col = new HashSet[9];
        Set<Character>[] subbox = new HashSet[9];
        for (int i = 0; i < 9; i++) {
            row[i] = new HashSet<>();
            col[i] = new HashSet<>();
            subbox[i] = new HashSet<>();
        }

        // 중복 체크 (contains 함수로 검사)
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                char tmp = board[r][c];
                if (tmp == '.') {
                    continue;
                } else {
                    int idx = ((r / 3) * 3 + (c / 3)); // subbox 인덱스 (0,3,6으로 행 시작, 0,1,2 더해서 열)
                    if (row[r].contains(tmp) || col[c].contains(tmp) || subbox[idx].contains(tmp)) {
                        return false; // 중복 시 F
                    }
                    row[r].add(tmp);
                    col[c].add(tmp);
                    subbox[idx].add(tmp);
                }
            }
        }
        return true; // 유효 시 T
    }
}

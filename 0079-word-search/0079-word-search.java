class Solution {
    // 212번의 하위호환 (단어 1개 (trie 필요X) + T/F 반환)
    public boolean exist(char[][] board, String word) {
        // Follow up) board 커지면: 
        // word 길이가 board 글자 수보다 많으면 바로 F
        if (word.length() > board.length * board[0].length) {
            return false;
        }

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                // 시작 글자 같으면 dfs 탐색
                if (board[row][col] == word.charAt(0)) {
                    if (dfs(board, word, row, col, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] map, String str, int r, int c, int i) {
        // 경계 조건 (+ 방문 여부)
        if (r < 0 || r >= map.length || c < 0 || c >= map[0].length || map[r][c] == '×') {
            return false;
        }

        // 마지막 글자 찾으면 종료
        if (i == str.length() - 1 && map[r][c] == str.charAt(i)) {
            return true;
        }

        // 다르면 종료
        if (map[r][c] != str.charAt(i)) {
            return false;
        }

        char tmp = map[r][c]; // 임시 저장
        map[r][c] = '×'; // 방문 처리
        // 상하좌우로 다음 글자 탐색
        boolean ex = (dfs(map, str, r + 1, c, i + 1) || dfs(map, str, r - 1, c, i + 1) || dfs(map, str, r, c + 1, i + 1)
                || dfs(map, str, r, c - 1, i + 1));
        map[r][c] = tmp; // 원상 복구
        return ex; // dfs 바로 return 시 복구 코드 실행 안되므로 이렇게 작성!
    }
}
class Node {
    Node[] near;
    String curr;

    // curr로 마지막 글자를 찾으면 그 글자까지의 온전한 단어를 찾은 것으로 보고 반환용 리스트에 담기
    // boolean ed + 단어 단위 DFS => 시간초과!
    public Node() {
        near = new Node[26]; // 알파벳
        curr = null; // 마지막 글자 체크 + 문자열 저장 (보드 단위 DFS)
    }
}

class Solution {
    // trie: words로 직접 만듦 + 문자열 유효한지 (마지막 글자) 체크 + curr에 해당 문자열 저장
    // board: 상하좌우 탐색 + 방문 처리 (임시로 다른 값으로)
    List<String> search; // 반환용 리스트

    public List<String> findWords(char[][] board, String[] words) {
        search = new ArrayList<>();
        // words로 trie 만들기
        Node root = makeTrie(words);
        // 시작점 dfs 탐색
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                find(board, root, row, col);
            }
        }
        return search;
    }

    // words 요소로 trie 만들기
    private Node makeTrie(String[] arr) {
        Node root = new Node();
        for (int i = 0; i < arr.length; i++) {
            Node now = root;
            for (int j = 0; j < arr[i].length(); j++) {
                char letter = arr[i].charAt(j);
                int ldx = letter - 'a';
                if (now.near[ldx] == null) {
                    now.near[ldx] = new Node();
                }
                now = now.near[ldx]; // 간선 이동
            }
            now.curr = arr[i]; // 마지막 도달 시 온전한 단어 저장
        }
        return root;
    }

    // DFS 상하좌우 탐색 (= trie에서 search)
    private void find(char[][] board, Node here, int r, int c) {
        // 임시 저장 (추후 방문 처리를 위함)
        char ch = board[r][c];
        if (ch == 'X')
            return; // 예외 처리 1
        // 방문부터 작성: 안 그러면 인덱스 초과 뜸
        // 이 문제는 소문자 확정이어서 대문자 X로 바꿔 줌
        int cdx = ch - 'a';
        if (here.near[cdx] == null)
            return; // 예외 처리 2

        // trie 탐색
        here = here.near[cdx]; // 간선 이동
        if (here.curr != null) {
            // 마지막 글자(찾은 글자)면 리스트 추가
            search.add(here.curr);
            here.curr = null; // 중복 방지용 초기화
        }
        board[r][c] = 'X'; // 방문 처리

        // dfs 상하좌우 탐색 (+ 경계 조건)
        if (r + 1 < board.length) {
            find(board, here, r + 1, c);
        }
        if (r - 1 >= 0) {
            find(board, here, r - 1, c);
        }
        if (c + 1 < board[0].length) {
            find(board, here, r, c + 1);
        }
        if (c - 1 >= 0) {
            find(board, here, r, c - 1);
        }

        // 원상 복구 (백트래킹)
        board[r][c] = ch;
    }
}
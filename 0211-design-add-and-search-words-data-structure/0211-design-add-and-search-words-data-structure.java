class Node {
    Node[] nxt; // 자식 노드 (다음 글자) a~z
    boolean ed; // 마지막 글자인가

    public Node() {
        nxt = new Node[26];
        ed = false;
    }
}

class WordDictionary {
    Node root;

    public WordDictionary() {
        root = new Node();
    }

    public void addWord(String word) {
        Node curr = this.root;
        for (int i = 0; i < word.length(); i++) {
            // 기존에 없으면 추가 => 불러옴
            int idx = word.charAt(i) - 'a';
            if (curr.nxt[idx] == null) {
                curr.nxt[idx] = new Node();
            }
            curr = curr.nxt[idx];
            // 마지막 글자 T 표시
            if (i == word.length() - 1) {
                curr.ed = true;
            }
        }
    }

    public boolean search(String word) {
        return search(word, this.root, 0); // 재귀 호출 결과만 반환
    }

    // 파라미터를 임의로 추가해서 만든 함수
    private boolean search(String word, Node node, int idx) {
        // 마지막 글자면 ed 반환
        if (idx == word.length()) {
            return node.ed;
        }

        char c = word.charAt(idx);
        if (c == '.') {
            // '.': DFS로 갈 수 있는지 모든 길 T/F 탐색
            for (int i = 0; i < 26; i++) {
                if (node.nxt[i] != null) {
                    if (search(word, node.nxt[i], idx + 1)) {
                        // 여러 경로(간선) 중 갈 수 있는 길이 하나라도 있으면 직접 T로 반환
                        return true;
                    }
                }
            }
            // 아예 길이 없으면 F로 반환
            return false;
        } else {
            // 알파벳: 글자 일치 여부 확인
            if (node.nxt[c - 'a'] == null) {
                return false;
            }
        }
        // 경로(간선)가 1가지로 정해져 있어 재귀 결과 바로 반환 가능
        return search(word, node.nxt[c - 'a'], idx + 1);
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
class Node {
    // Node 클래스 직접 구현해야 함
    Map<Character, Node> child; // 자식 노드들 저장
    boolean ed; // 끝 노드 (문자열 중간에 끝났는지 체크)

    public Node() {
        this.ed = false;
        this.child = new HashMap<>();
    }
}

class Trie {
    // Java는 Trie (tree + hashmap/배열) 직접 구현 필요
    // Trie: 루트는 빈 노드, 한 글자씩 노드에 넣어 연결 
    // 예) apple이면 루트-a-p-p-l-e: 깊이 5
    Node root;

    public Trie() {
        this.root = new Node(); // 루트: 빈 노드
    }

    public void insert(String word) {
        // 기존에 없으면 추가
        // 있으면 따라 내려가고 마지막 글자에서 true
        // (삭제는 마지막 글자 false 처리)
        Node curr = this.root; // 현재 포인터 (루트에서 시작)
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!curr.child.containsKey(c)) {
                curr.child.put(c, new Node()); // 자식 노드 추가로 생성 후 put
            }
            curr = curr.child.get(c); // 해당 자식 노드로 이동
        }
        // 마지막 노드의 끝 처리
        curr.ed = true;
    }

    public boolean search(String word) {
        // 있는 노드 따라 내려가서 T/F
        Node curr = this.root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!curr.child.containsKey(c)) {
                return false;
            }
            curr = curr.child.get(c);
        }
        return curr.ed; // 마지막 노드에서 ed가 T면 T

    }

    public boolean startsWith(String prefix) {
        // prefix 길이만큼 따라 내려가서 T/F
        Node curr = this.root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (!curr.child.containsKey(c)) {
                return false;
            }
            curr = curr.child.get(c);
        }
        return true; // curr.ed와 무관하게 접두사만 모두 있어도 T
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
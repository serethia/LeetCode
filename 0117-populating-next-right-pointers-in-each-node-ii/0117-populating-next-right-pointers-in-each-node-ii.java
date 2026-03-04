/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    // constant extra space = O(1) 공간복잡도
    // => 포인터 활용 (큐는 O(n)이어서 X)
    // (2^n 활용은 완전이진트리에서만!)
    public Node connect(Node root) {
        // 0개 예외 처리
        if (root == null) {
            return null;
        }

        Node n = root; // 원본 노드 순회 & 갱신

        // <1> 전체 탐색
        while (n != null) {
            Node curr = n; // 현위치 포인터
            // 자식이 없다면 nxtSt, nxtEd 모두 null
            Node nxtSt = null; // 다음 깊이 시작점
            Node nxtEd = null; // 다음 깊이 끝점

            // <2> 현재 깊이 탐색
            while (curr != null) {
                // [1] 왼쪽 자식이 있다면
                if (curr.left != null) {
                    if (nxtSt == null) {
                        // [1-1] 시작점 & 끝점 설정
                        nxtSt = curr.left;
                        nxtEd = curr.left;
                    } else {
                        // [1-2] 끝점 갱신
                        nxtEd.next = curr.left;
                        nxtEd = nxtEd.next;
                    }
                }
                // [2] 오른쪽 자식이 있다면
                if (curr.right != null) {
                    if (nxtSt == null) {
                        // [2-1] 시작점 & 끝점 설정
                        nxtSt = curr.right;
                        nxtEd = curr.right;
                    } else {
                        // [2-2] 끝점 갱신
                        nxtEd.next = curr.right;
                        nxtEd = nxtEd.next;
                    }
                }
                curr = curr.next; // 그 다음 노드로
            }

            n = nxtSt; // 다음 깊이로
        }

        return root; // 갱신한 root 반환
    }
}
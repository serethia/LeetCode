/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    // Node 안에 Node 들어간 생성자는 random 때문에 비추
    public Node copyRandomList(Node head) {
        // Deep copy: 주소가 아니라 값을 복사
        // random은 null도 가능: Node로 다뤄야
        Map<Node, Node> map = new HashMap<>(); // [원본, 복사본]
        Node copy = new Node(0); // 더미 0으로 시작
        Node headPt = head; // 포인터1
        Node copyPt = copy; // 포인터2

        // 맵에 복사본 넣기
        while (headPt != null) {
            Node curr = new Node(headPt.val); // 복사한 노드
            copyPt.next = curr; // 더미 뛰어 넘고 복사 노드부터 시작 (= currPt는 null 검사 필요 X)
            map.put(headPt, curr);
            copyPt = copyPt.next;
            headPt = headPt.next;
        }

        // random 노드만 map.get으로 불러오기
        headPt = head;
        copyPt = copy.next;
        while (headPt != null) {
            copyPt.random = map.get(headPt.random);
            copyPt = copyPt.next;
            headPt = headPt.next;
        }

        return copy.next; // 더미 뛰어 넘고 반환
    }
}
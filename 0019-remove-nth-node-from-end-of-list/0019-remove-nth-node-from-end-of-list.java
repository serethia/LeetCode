/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 뒤에서 n번째 노드 & one pass
        ListNode ln = new ListNode(0);
        // 더미 필요: 제거할 노드의 앞으로 가기 위함
        ln.next = head;
        // 투 포인터: n 간격으로 s(low), f(ast)
        ListNode f = ln; // 더미부터, s + n
        ListNode s = ln; // 더미부터
        for (int i = 0; i < n; i++) {
            f = f.next; // n만큼 뒤에서 시작
        }

        // f는 마지막 노드, s는 제거 노드의 앞 노드
        while (f.next != null) {
            f = f.next;
            s = s.next;
        }

        // 노드 제거: 이전의 next를 이후 노드로 재연결
        s.next = s.next.next;
        // 더미 건너뛰고 반환
        return ln.next;
    }
}
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
    public ListNode deleteDuplicates(ListNode head) {
        // 노드가 0개인 경우 예외처리
        if (head == null) {
            return null;
        }

        ListNode ln = new ListNode(0);
        ln.next = head;
        ListNode st = ln; // 앞 포인터 (더미부터 연결)
        ListNode ed = ln.next; // 뒤 포인터 (크기 비교)

        // 이미 오름차순: 앞보다 같거나 큰 값만 나옴
        while (ed != null) {
            if (ed.next != null && ed.next.val == ed.val) {
                // [1] 중복 건너뛰고 재연결
                while (ed.next != null && ed.next.val == ed.val) {
                    ed = ed.next;
                }
                st.next = ed.next;
            } else {
                // [2] 크거나 마지막이면 재연결
                st.next = ed;
                st = st.next;
            }
            ed = ed.next;
        }

        return ln.next;
    }
}
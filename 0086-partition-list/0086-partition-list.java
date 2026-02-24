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
    public ListNode partition(ListNode head, int x) {
        // 예외처리
        if (head == null) {
            return null;
        }

        // [x미만]|[x이상]으로 배치 (정렬X)
        ListNode smallln = new ListNode(0);
        ListNode bigln = new ListNode(0);
        ListNode st = smallln; // 앞 구간 포인터
        ListNode ed = bigln; // 뒷 구간 포인터

        // 두 구간으로 분류
        while (head != null) {
            if (head.val < x) {
                st.next = head;
                st = st.next;
            } else {
                ed.next = head;
                ed = ed.next;
            }
            head = head.next;
        }

        // 그대로 연결해 반환
        ed.next = null; // 사이클 방지
        st.next = bigln.next;
        return smallln.next;
    }
}
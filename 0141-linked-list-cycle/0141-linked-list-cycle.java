/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        // BufferedReader로 입력받을 필요X
        // 예외 처리
        // head 자체도 null 판단해야 next에서 오류X
        if (head == null || head.next == null) {
            return false;
        }

        ListNode st = head;
        ListNode ed = head;
        while (ed != null && ed.next != null) {
            // cycle이 있다면 필연적으로 만남
            st = st.next; // 1칸 이동
            ed = ed.next.next; // 2칸 이동
            // ed가 st와 만나 같아지면 T
            if (ed == st) {
                return true;
            }
        }
        return false;
    }
}
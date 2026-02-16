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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode merge = new ListNode(0); // 반환용
        ListNode pt = merge; // 포인터

        // tail 도달 전까지 오름차순 정렬
        while (list1 != null && list2 != null) {
            // 같거나 작은 값으로 노드 추가
            if (list1 != null && list2 != null) {
                if (list2.val <= list1.val) {
                    pt.next = list2;
                    list2 = list2.next;
                } else {
                    pt.next = list1;
                    list1 = list1.next;
                }
                pt = pt.next;
            }
        }

        // 나머지는 노드에 연결
        if (list1 != null) {
            pt.next = list1;
        } else {
            pt.next = list2;
        }
        // 임의로 넣은 head(0) 건너뛰고 반환
        return merge.next;
    }
}
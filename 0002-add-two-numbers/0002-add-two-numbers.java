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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // head부터 일의 자리 (맨앞 0은 임의로)
        ListNode addNode = new ListNode(0);
        // 현재 노드 참조용 포인터 pt
        ListNode pt = addNode;

        // int로 총합 지정했더니 overflow 발생
        // 리스트 활용해 자릿수마다 바로 계산해야
        int curr = 0;
        // curr != 0이면 남은 자릿수 값을 위해 한 번 더 루프
        while (l1 != null || l2 != null || curr != 0) {
            // 자릿수마다 계산할 합
            int currSum = curr;
            if (l1 != null) {
                currSum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                currSum += l2.val;
                l2 = l2.next;
            }

            // 자릿수 넘어간 경우도 대비
            // curr = 10의 자리 넘어간 값
            // 노드에 넣을 숫자 = 1의 자리 값
            curr = currSum / 10;
            pt.next = new ListNode(currSum % 10);
            pt = pt.next;
        }

        // 맨앞에 임의로 넣은 0은 건너뛰고 반환
        return addNode.next;
    }
}
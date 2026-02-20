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
    public ListNode reverseKGroup(ListNode head, int k) {
        // (HashMap<Node, Node> : O(n))
        ListNode ln = new ListNode(0); // 더미
        ln.next = head;
        ListNode here = ln; // 삽입 장소 (더미 시작)

        while (true) {
            ListNode able = here; // k개 이상인지 판단
            // [1] k개 이상이면 k번째로 이동
            for (int i = 0; i < k; i++) {
                able = able.next;
                // [1'] k개 미만이면 원본 그대로 for문 break
                if (able == null) {
                    break;
                }
            }
            // [1'] k개 미만이면 원본 그대로 while문 break
            if (able == null) {
                break;
            }

            // 맨 앞 st를 기준으로 앞으로 끌어와 삽입
            // '맨 뒤'가 아니라 '맨 앞'이 기준
            ListNode st = here.next; // 뒤집을 기준점 (구간의 첫 노드)

            // [2] 앞쪽으로 삽입 : reverse
            for (int i = 0; i < (k - 1); i++) {
                ListNode bring = st.next; // 데려와 뒤집을 노드
                st.next = bring.next;
                bring.next = here.next;
                here.next = bring;
            }

            // [3] 다음 구간 첫 노드로 삽입 포인터 이동
            here = st;
        }

        // 더미 건너뛰고 노드 리스트 반환
        return ln.next;
    }
}
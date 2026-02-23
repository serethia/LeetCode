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
    public ListNode rotateRight(ListNode head, int k) {
        // (예외 처리 1)
        if (head == null) {
            return null;
        }

        // [1] 총 개수 구하기
        ListNode tot = head;
        int len = 1;
        while (tot.next != null) {
            tot = tot.next;
            len++;
        }

        // [2] k를 len으로 나눈 나머지로 계산
        k %= len;
        // (예외 처리 2)
        if (k == 0) {
            return head;
        }
        // 마지막 노드를 head에 연결: 사이클
        tot.next = head;

        // [3] 시작(st) & 종료(ed) 지점 탐색
        ListNode ed = head;
        int tmp = (len - k - 1);
        for (int i = 0; i < tmp; i++) {
            ed = ed.next;
        }
        ListNode st = ed.next;
        ed.next = null;

        // [4] 실제 시작 지점 st부터 반환
        ListNode ln = st;
        return ln;
    }
}
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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // one pass: 반복해서 next 직접 재연결
        // (양방향 동시 swap: 배열에서는 가능)
        ListNode ln = new ListNode(0);
        ln.next = head;

        // 시작점 뒤의 노드들을 앞으로 끌어오기
        // ins: 뒤집을 구간 시작 지점의 이전 노드
        ListNode ins = ln; // 고정
        for (int i = 0; i < (left - 1); i++) {
            ins = ins.next; // (left-1)번째로 이동
        }

        // ed: 뒤집을 구간 맨 왼쪽에 있었던 노드
        // rev: 앞으로 데려 올 현재 노드
        ListNode ed = ins.next; // 고정
        for (int i = 0; i < (right - left); i++) {
            // 삽입할 (시작점의 다음) 노드를 자름
            ListNode rev = ed.next;
            // 구간 맨 왼쪽 노드의 next를 방금 자른 노드의 다음 노드로 변경해 둠
            ed.next = rev.next;
            // 자른 노드의 next를 뒤집은 구간의 첫 노드와 연결
            rev.next = ins.next;
            // 자른 노드를 삽입
            ins.next = rev;
        }

        // 뒤집을 필요 없다면 원본 그대로 반환
        // 뒤집었다면 더미 0 건너뛰고 반환
        if (left == right) {
            return head;
        } else {
            return ln.next;
        }
    }
}
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
    // Follow up: 포인터 2개로 중간 mid 찾기
    // mid 기준 좌우 분할
    // 재귀로 1개짜리가 될 때까지 쪼개기
    // 둘씩 val 비교해 작은 쪽을 합치면서 정렬
    // (* swap 정렬: 시간복잡도 안 좋음)
    public ListNode sortList(ListNode head) {
        // 더 이상 쪼갤 것이 없다면
        if (head == null || head.next == null) {
            return head;
        }

        // 속도 1칸 차이 slow-fast로 (왼쪽) 중간값 찾기
        ListNode st = head; // slow
        ListNode ed = head.next; // fast
        // (* ed = head 시작: mid가 오른쪽 중간값이 되어버림)
        while (ed != null && ed.next != null) {
            // (* ed.next != null 검사: 안 하면 2칸 이동 시 ed.next.next에서 nullpointerexception 오류 뜸)
            // ed 맨 끝 도달 = st 중간 도달
            st = st.next; // 1칸씩
            ed = ed.next.next; // 2칸씩
        }

        // st.next 기준으로 앞뒤 분할 (mid)
        ListNode mid = st.next;
        st.next = null;

        ListNode lft = sortList(head);
        ListNode rgt = sortList(mid);
        return merge(lft, rgt);
    }

    private ListNode merge(ListNode left, ListNode right) {
        ListNode tmp = new ListNode(0); // 더미
        ListNode curr = tmp; // 포인터

        // 두 리스트 중 더 작은 쪽을 next로 연결
        // 두 리스트 비교할 동안 둘 다 null이 아니어야 함
        while (left != null && right != null) {
            if (left.val > right.val) {
                curr.next = right;
                right = right.next;
            } else {
                curr.next = left;
                left = left.next;
            }
            curr = curr.next; // next로 이동
        }

        // 하나라도 null이 뜨면 val 비교 종료
        // 그 중 남은 리스트 마저 연결 후 반환
        curr.next = (left != null) ? left : right;
        return tmp.next;
    }
}
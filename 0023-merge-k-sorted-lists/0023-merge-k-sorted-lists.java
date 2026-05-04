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
    // 큐처럼 맨 앞을 비교한다 생각하자
    // 분할 정복을 2개 이상의 k개로 진행한다면?
    // k개를 절반씩 분할&정복
    // 결과들을 계속 merge 및 자동 정렬
    public ListNode mergeKLists(ListNode[] lists) {
        return lists == null || lists.length == 0 ? null : divide(0, lists.length - 1, lists);
    }

    // * divide: 1개 리스트 될 때까지 절반 쪼개기
    private ListNode divide(int st, int ed, ListNode[] nodes) {
        // 1개 단위 리스트는 그대로 반환
        if (st == ed) {
            return nodes[st];
        }
        // 절반 범위로 반복 쪼개기 위한 중간 인덱스
        int mid = st + (ed - st) / 2;
        ListNode left = divide(st, mid, nodes);
        ListNode right = divide(mid + 1, ed, nodes);
        // 좌우 그룹 merge
        return merge(left, right);
    }

    // * merge: 정렬 & 합치기
    private ListNode merge(ListNode lft, ListNode rgt) {
        ListNode root = new ListNode(0);
        ListNode sorted = root;
        // 두 리스트 중 더 작은 쪽 값을 추가 
        // (한 리스트가 모두 끝나기 전까지)
        while (lft != null && rgt != null) {
            if (lft.val <= rgt.val) {
                sorted.next = lft;
                lft = lft.next;
            } else {
                sorted.next = rgt;
                rgt = rgt.next;
            }
            sorted = sorted.next;
        }
        // 한 쪽이 끝나면 반대 쪽을 그대로 붙이기
        if (lft != null) {
            sorted.next = lft;
        } else {
            sorted.next = rgt;
        }
        // 더미 다음 노드부터 연결된 리스트 반환
        return root.next;
    }
}
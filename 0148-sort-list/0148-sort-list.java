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
    // * Follow up: 재귀보다 공간복잡도 좋은 방법
    // 반복문 2개(for, while)로 bottom-up
    // 앞에서부터 n(크기)개씩 묶어서 정렬
    // 밖: 크기 2배, 안: 둘로 나눠 머지
    public ListNode sortList(ListNode head) {
        int tot = 0; // 총 개수
        ListNode tmp = head;
        while (tmp != null) {
            tot++;
            tmp = tmp.next;
        }

        ListNode root = new ListNode(0); // 더미
        root.next = head; // 포인터
        // n 크기만큼 묶어서 분할 & 정렬
        for (int n = 1; n < tot; n *= 2) {
            ListNode here = root.next;
            ListNode last = root; // 더미부터 연결
            while (here != null) {
                ListNode lft = here; // 왼쪽 그룹
                ListNode rgt = getSt(here, n); // 오른쪽 그룹
                here = getSt(rgt, n); // 그 다음 시작점으로 이동
                ListNode m = merge(lft, rgt); // 두 그룹 정렬 & 머지
                last.next = m; // 마지막 포인터에 연결
                // 마지막 포인터를 다음 마지막 자리로 이동
                while (last.next != null) {
                    last = last.next;
                }
            }
        }
        return root.next;
    }

    // (* 제출해서 맞춘 또 다른 풀이: 재귀)
    // (IF 재귀를 쓴다면:
    // 포인터 2개로 중간 mid 찾기
    // mid 기준 좌우 분할
    // 재귀로 1개짜리가 될 때까지 쪼개기
    // 둘씩 val 비교해 작은 쪽을 합치면서 정렬)
    // (* swap 정렬: 시간복잡도 안 좋음)
    //public ListNode sortList(ListNode head) {
    // 더 이상 쪼갤 것이 없다면
    //if (head == null || head.next == null) {
    //return head;
    //}

    // 속도 1칸 차이 slow-fast로 (왼쪽) 중간값 찾기
    //ListNode st = head; // slow
    //ListNode ed = head.next; // fast
    // (* ed = head 시작: mid가 오른쪽 중간값이 되어버림)
    //while (ed != null && ed.next != null) {
    // (* ed.next != null 검사: 안 하면 2칸 이동 시 ed.next.next에서 nullpointerexception 오류 뜸)
    // ed 맨 끝 도달 = st 중간 도달
    //st = st.next; // 1칸씩
    //ed = ed.next.next; // 2칸씩
    //}

    // st.next 기준으로 앞뒤 분할 (mid)
    //ListNode mid = st.next;
    //st.next = null;

    // (* 재귀 활용: 공간 O(logn)이어서 X)
    //ListNode lft = sortList(head);
    //ListNode rgt = sortList(mid);
    //return merge(lft, rgt);
    //}

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

    // bottom-up에서 추가되는 함수: getSt
    private ListNode getSt(ListNode st, int nums) {
        if (st == null) {
            return null;
        }

        // 시작점을 n(ums)-1만큼 이동: 다음 시작점
        for (int i = 1; i < nums; i++) {
            if (st.next != null) {
                st = st.next;
            }
        }

        // st.next 기준으로 분할 (mid 구할 때처럼)
        ListNode begin = st.next;
        st.next = null;
        return begin; // 뒤가 null인 다음 시작점 반환
    }
}
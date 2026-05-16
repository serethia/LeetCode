class Solution {
    // 두 배열 모두 오름차순 보장됨
    // = 오른쪽 오름차순, 아래쪽 오름차순 보장됨
    // => nums1를 row, nums2를 col로 가정
    // => set: (nums1 인덱스, nums2 인덱스)쌍
    // => pq에 각 row의 첫 col들을 넣음
    // => 첫 row부터 뽑고, 바로 다음 col을 넣음
    // => pq로 (row 값 + col 값) 오름차순 자동 정렬
    // => 해당 (nums1 값, nums2 값)쌍 리스트에 저장
    // => k쌍 뽑아낸 리스트 최종 반환
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        // (nums1 값, nums2 값) 저장할 리스트
        List<List<Integer>> l = new ArrayList<>();
        // set1, set2 넣을 우선순위 큐
        // set(1 or 2)[0]: nums1 인덱스
        // set(1 or 2)[1]: nums2 인덱스
        // 합한 값을 기준으로 오름차순
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (set1, set2) -> Integer.compare((nums1[set1[0]] + nums2[set1[1]]), (nums1[set2[0]] + nums2[set2[1]])));

        // nums1 길이보다 k가 작을 때: k면 바로 offer 종료
        int min = Math.min(k, nums1.length);
        for (int i = 0; i < min; i++) {
            pq.offer(new int[] { i, 0 });
        }

        // k쌍 뽑기 (pq 비지 않는 전제 하에)
        while (!pq.isEmpty() && k > 0) {
            int[] tmp = pq.poll();
            List<Integer> ll = new ArrayList<>();
            ll.add(nums1[tmp[0]]);
            ll.add(nums2[tmp[1]]);
            l.add(ll); // (nums1 값, nums2 값)쌍 추가

            // 다음 후보 추가 시 경계 조건 확인
            if (tmp[1] + 1 < nums2.length) {
                // 뽑은 row의 다음 col 후보 추가
                pq.offer(new int[] { tmp[0], (tmp[1] + 1) });
            }
            k--; // 0이 될 때까지 뽑을 때마다 감소
        }

        return l;
    }
}
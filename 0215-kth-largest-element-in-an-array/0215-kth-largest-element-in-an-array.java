class Solution {
    // 우선순위 큐 활용
    // Collections.reverseOrder() 추가 시 역순(큰 순서대로)
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < nums.length; i++) {
            pq.offer(nums[i]);
        }

        int kth = 0;
        for (int j = 1; j <= k; j++) {
            kth = pq.poll();
        }
        return kth;
    }
}
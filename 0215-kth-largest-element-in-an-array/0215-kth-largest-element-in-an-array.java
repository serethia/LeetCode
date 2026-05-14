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
    // * 문제에서 권장하는 알고리즘: quickselect
    // 선형탐색은 계속 하되, 찾는 순위가 포함된 구간을 좁혀나감
    // ex) 예를 들어 k번째 큰 숫자를 찾는 문제:
    // 처음에는 맨 오른쪽 값을 기준으로 더 큰 숫자들만 기준점 왼쪽에 두고
    // 왼쪽 총 개수를 세며 몇 번째 큰 숫자인지 보고
    // k에 맞추도록 포함된 구간만 좁혀가며 반복 탐색
}
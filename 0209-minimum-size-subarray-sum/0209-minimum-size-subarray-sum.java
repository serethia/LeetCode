class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        // O(nlogn): 누적합 & 이분탐색
        // O(n): 슬라이딩 윈도우 (길이 고정) or 투 포인터 (길이 가변)
        int st = 0;
        int ed = 0;
        int sum = 0;
        // 입력값 사전 점검
        if (nums.length == 0) {
            return 0;
        }

        int min = Integer.MAX_VALUE;
        while (ed < nums.length) {
            // 오른쪽 포인터 이동
            sum += nums[ed];
            ed++;
            while (sum >= target) {
                // 최소 길이로 갱신 & 왼쪽 포인터 이동
                min = Math.min((ed - st), min);
                sum -= nums[st];
                st++;
            }
        }
        // 부분배열 없다면 0, 있다면 최소 길이
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
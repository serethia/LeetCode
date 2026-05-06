class Solution {
    // 길이 1 이상: 예외 처리 필요X
    // 앞에서부터 포인터 2개를 돌리면 비효율적
    // Kadane + 원형 => 2가지 경우!
    // 1. 끊기면: (전체합 - 최소 부분합)
    // 2. 연속되면: (최대 부분합)
    public int maxSubarraySumCircular(int[] nums) {
        int tot = nums[0];
        int min = nums[0];
        int tmpMin = nums[0];
        int max = nums[0];
        int tmpMax = nums[0];
        for (int i = 1; i < nums.length; i++) {
            tot += nums[i];
            min = Math.min(nums[i], min + nums[i]);
            tmpMin = Math.min(tmpMin, min);
            max = Math.max(nums[i], max + nums[i]);
            tmpMax = Math.max(tmpMax, max);
        }
        // 최대 합이 음수(모든 원소가 음수)일 때 예외 처리
        return tmpMax < 0 ? tmpMax : Math.max((tot - tmpMin), tmpMax);
    }
}
class Solution {
    // 연속되는 원소들의 최대 합: Kadane 알고리즘
    // * 권장 알고리즘: divide & conquer 추가
    // * 절반 나누고 뒤에서부터 총합도 구해서 max
    // * 앞에서부터 최대 합 + 뒤에서부터 최대 합
    // * 좌/우: 구간 합 vs. 앞/뒤에서부터 최대 합
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int maxTmp = nums[0];
        for (int i = 1; i < nums.length; i++) {
            maxTmp = Math.max(nums[i], maxTmp + nums[i]);
            max = Math.max(max, maxTmp);
        }
        return max;
    }
}
class Solution {
    public int searchInsert(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= target) {
                return i; // 맨 처음 ~ 중간
            }
        }
        return nums.length; // 맨 끝
    }
}
class Solution {
    public int removeDuplicates(int[] nums) {
        int k = 1;
        int cnt = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                cnt = 1;
            } else {
                cnt++;
            }
            if (cnt <= 2) {
                if (nums[k] != nums[i]) {
                    nums[k] = nums[i];
                }
                k++;
            }
        }
        return k;
    }
}
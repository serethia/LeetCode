class Solution {
    public int findMin(int[] nums) {
        int st = 0;
        int ed = nums.length - 1;
        while (st < ed) {
            int mid = st + (ed - st) / 2;
            if (nums[mid] > nums[ed]) {
                // 우측 구간
                st = mid + 1;
            } else {
                // 좌측 구간
                ed = mid;
            }
        }
        return nums[st];
    }
}
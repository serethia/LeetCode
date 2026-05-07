class Solution {
    public int findPeakElement(int[] nums) {
        // 산의 정상 찾기: 이분탐색
        int st = 0;
        int ed = nums.length - 1;
        while (st < ed) {
            int mid = (st + ((ed - st) / 2));
            if (nums[mid] < nums[mid + 1]) {
                // 상향
                st = mid + 1;
            } else {
                // 하향
                ed = mid;
            }
        }
        return st;
    }
}
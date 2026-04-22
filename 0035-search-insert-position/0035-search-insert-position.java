class Solution {
    // 권장된 시간복잡도: O(logn) = 이분탐색
    public int searchInsert(int[] nums, int target) {
        // 중앙값과 비교해 타겟 포함 구간만 남기기
        int st = 0;
        int ed = nums.length - 1;
        while (st <= ed) {
            int mid = ((ed - st) / 2 + st);
            if (nums[mid] == target) {
                // 타겟 위치 발견
                return mid;
            } else if (nums[mid] > target) {
                // 앞쪽 구간
                ed = mid - 1;
            } else {
                // 뒤쪽 구간
                st = mid + 1;
            }
        }
        // st: 타겟 이상 값, ed: 타겟 미만 값 => st 반환
        return st; // st > ed인 경우: st
    }

    // * 얘도 가능하긴 하지만, 시간복잡도가 O(n) *
    // public int searchInsert(int[] nums, int target) {
    // for (int i = 0; i < nums.length; i++) {
    // if (nums[i] >= target) {
    // return i; // 맨 처음 ~ 중간
    // }
    // }
    // return nums.length; // 맨 끝
    // }
}
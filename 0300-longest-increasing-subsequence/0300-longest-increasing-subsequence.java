class Solution {
    // 시간 O(n^2): 일반 DP (이중 for문)
    // 시간 O(nlogn): 새 배열 정렬 상태 유지하며 이분탐색
    // => DP를 최적화한 그리디 + 이분탐색 (dp배열 필요 X)
    // 더 작은 값을 붙여 추가될 숫자의 가능성을 높임
    public int lengthOfLIS(int[] nums) {
        // 배열을 arraylist로 해도 무방
        int[] lis = new int[nums.length];
        int len = 0; // lis의 최대 길이
        for (int i = 0; i < nums.length; i++) {
            if (len == 0 || lis[len - 1] < nums[i]) {
                // 맨 끝에 추가
                lis[len++] = nums[i];
            } else {
                // 값 이상 되는 최초 자리와 교체
                int st = 0;
                int ed = len - 1;
                while (st < ed) {
                    int mid = st + (ed - st) / 2;
                    if (lis[mid] >= nums[i]) {
                        ed = mid;
                    } else {
                        st = mid + 1;
                    }
                }
                lis[st] = nums[i];
            }
        }
        return len;
    }
}
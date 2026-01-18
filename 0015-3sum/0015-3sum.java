class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> tri = new ArrayList<>();
        int len = nums.length;
        // 정렬 & 사전점검
        Arrays.sort(nums);
        if (nums[0] > 0 || nums[len - 1] < 0) {
            return tri; // 해당 조합 없음: 빈 값 반환
        }

        // 투 포인터 응용: 셋 다 값이 다르며 합이 0
        for (int st = 0; st < len - 2; st++) {
            // 다른 값 나올 때까지 오른쪽으로
            if (st > 0 && nums[st] == nums[st - 1]) {
                continue;
            }
            int mid = st + 1;
            int ed = len - 1;
            while (mid < ed) {
                int sum = nums[st] + nums[mid] + nums[ed];
                if (sum == 0) {
                    // 총 개수 불확실: for문 초기화보다 arrays.aslist 활용
                    tri.add(Arrays.asList(nums[st], nums[mid], nums[ed]));
                    // 다른 값 나올 때까지 왼쪽으로
                    do {
                        ed--;
                    } while (mid < ed && nums[ed] == nums[ed + 1]);
                    // 다른 값 나올 때까지 오른쪽으로
                    do {
                        mid++;
                    } while (mid < ed && nums[mid] == nums[mid - 1]);
                } else if (sum > 0) {
                    // 다른 값 나올 때까지 왼쪽으로
                    do {
                        ed--;
                    } while (mid < ed && nums[ed] == nums[ed + 1]);
                } else {
                    // 다른 값 나올 때까지 오른쪽으로
                    do {
                        mid++;
                    } while (mid < ed && nums[mid] == nums[mid - 1]);
                }
            }
        }
        return tri;
    }
}
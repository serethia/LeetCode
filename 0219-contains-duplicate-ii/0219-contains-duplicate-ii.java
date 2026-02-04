class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        // 키: nums 요소, 값: 인덱스
        Map<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int curr = nums[i];
            // 같은 값이 존재함 조건 충족하는지
            if (m.containsKey(curr)) {
                // 인덱스 차가 k 이하임 조건 충족하는지
                if (i - m.get(curr) <= k) {
                    return true;
                }
            }
            // 조건 미충족 시 curr의 인덱스를 i로 갱신
            m.put(curr, i);
        }
        return false;
    }
}
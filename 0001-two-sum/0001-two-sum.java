class Solution {
    public int[] twoSum(int[] nums, int target) {
        // 키: nums 요소
        // 값: 인덱스 번호
        Map<Integer, Integer> substract = new HashMap<>();
        // 뺀 나머지 값을 key로 다시 get
        // 현재 인덱스와 get한 인덱스의 쌍을 반환
        for (int i = 0; i < nums.length; i++) {
            int leftover = (target - nums[i]);
            if (substract.containsKey(leftover)) {
                return new int[] { (substract.get(leftover)), i };
            }
            substract.put(nums[i], i); // 중복 방지를 위해 검사 후 저장
        }
        return null;
    }
}
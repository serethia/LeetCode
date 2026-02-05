class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        int max = 0;
        // 인덱스가 아니라 값의 연속성 = for-each
        // nums를 돌면 시간 초과 => set
        for (int i : set) {
            // 이전 값이 이미 있으면 시작점 pass
            if (!set.contains(i - 1)) {
                // 다음 값이 있는 동안 계속 증가
                int len = 1; // 현재 값 포함
                while (set.contains(i + 1)) {
                    len++;
                    i++;
                }
                max = Math.max(max, len);
            }
        }
        return max;
    }
}
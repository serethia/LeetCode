class Solution {
    // i, i-1 연속은 피할 것 => 최대 획득 금액
    // 배열을 변수 2개로 바꿔 공간복잡도 최적화!
    public int rob(int[] nums) {
        int minusTwo = 0; // 배열상 [i-2]
        int minusOne = 0; // 배열상 [i-1]
        for (int i = 0; i < nums.length; i++) {
            int max = Math.max(minusTwo + nums[i], minusOne); // 현재 i번째 최댓값
            minusTwo = minusOne; // i++되므로 값 이동
            minusOne = max; // i++되므로 값 이동
        }
        return minusOne; // 최종 max값 반환
    }
}
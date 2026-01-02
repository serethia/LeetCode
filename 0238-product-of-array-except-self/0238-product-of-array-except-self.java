class Solution {
    public int[] productExceptSelf(int[] nums) {
        int size = nums.length;
        int[] fromLeft = new int[size];
        int[] fromRight = new int[size];
        int[] answer = new int[size];

        fromLeft[0] = 1;
        fromRight[size - 1] = 1;

        for (int i = 1; i < size; i++) {
            fromLeft[i] = fromLeft[i - 1] * nums[i - 1];
        }

        for (int i = size - 2; i >= 0; i--) {
            fromRight[i] = fromRight[i + 1] * nums[i + 1];
        }

        for (int i = 0; i < size; i++) {
            answer[i] = fromLeft[i] * fromRight[i];
        }

        return answer;
    }
}
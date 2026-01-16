class Solution {
    public int[] twoSum(int[] numbers, int target) {
        // 투 포인터
        int st = 0;
        int ed = numbers.length - 1;
        int[] indices = new int[2]; // 지수 저장
        while (st < ed) {
            int sum = numbers[st] + numbers[ed];
            if (sum == target) {
                indices[0] = st + 1;
                indices[1] = ed + 1;
                break;
            } else if (sum > target) {
                ed--;
            } else {
                st++;
            }
        }
        return indices;
    }
}
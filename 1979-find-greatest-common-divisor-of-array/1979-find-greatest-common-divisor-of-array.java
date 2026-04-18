class Solution {
    public int findGCD(int[] nums) {
        // 가장 큰 값과 가장 작은 값의 최대공약수(GCD)
        // 최대, 최소만 구하는 문제라서 arrays.sort(nums)보다 
        // for문으로 math함수 돌리는 게 나음
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
        }
        int g = searchGcd(max, min);
        return g;
    }

    // 공간복잡도를 엄격히 O(1)로 하려면 재귀를 반복문으로 변경하면 됨
    private int searchGcd(int a, int b) {
        if (a % b == 0) {
            return b;
        }
        return searchGcd(b, (a % b));
    }
}
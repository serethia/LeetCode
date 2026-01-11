class Solution {
    public int candy(int[] ratings) {
        int[] min = new int[ratings.length];
        for (int i = 0; i < min.length; i++) {
            min[i] = 1; // 최소 1개씩
        }

        // 왼 => 오
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                min[i] = min[i - 1] + 1;
            }
        }
        // 오 => 왼
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                min[i] = Math.max(min[i], min[i + 1] + 1); // 위에서 구한 값과 비교한 최대값
            }
        }

        // 총량 최소값 계산
        int total = 0;
        for (int candies : min) {
            total += candies;
        }
        return total;
    }
}
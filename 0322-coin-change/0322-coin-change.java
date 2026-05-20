class Solution {
    // if) 정렬 후 큰 값부터 나머지(%) 구하기:
    // 테스트 일부는 맞지만, 원하는 건 "최소 개수"
    // => DP로 각각의 필요 수 갱신 (정렬 필요 X)
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        // Arrays.fill: 배열을 그 값으로 초기화
        // Integer.MAX_VALUE는 이후 +1에서 초과 발생: 불가능
        // amount+1은 못 도달할 바깥 범위 최솟값
        Arrays.fill(dp, amount + 1);
        dp[0] = 0; // amount == 0이면 0
        Arrays.sort(coins); // 최적화용 정렬
        for (int i = 1; i < dp.length; i++) {
            for (int c = 0; c < coins.length; c++) {
                // 정렬한 후 값보다 크면 종료
                if (coins[c] > i) {
                    break;
                }
                // 사용vs.미사용 최소 개수 구하기 (Math.min)
                dp[i] = Math.min(dp[i], dp[i - coins[c]] + 1);
            }
        }
        // 조합 없으면 -1, 있으면 최소 개수로
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }
}
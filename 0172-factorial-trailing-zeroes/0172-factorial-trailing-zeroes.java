class Solution {
    public int trailingZeroes(int n) {
        // n까지 곱 => 2는 충분 => 5의 개수
        // 직접 팩토리얼값 구해 10으로 나누면 위험
        int num = 0;
        for (int i = 5; i <= n; i *= 5) {
            // 5의 거듭제곱은 for문 조건에 작성
            num += (n / i);
        }
        return num;
    }
}
class Solution {
    // 단순 제곱 => 시간 초과
    public double myPow(double x, int n) {
        long m = n; // 안전하게 형변환
        if (m == 0) {
            return 1.0;
        } else if (m < 0) {
            x = 1 / x;
            m *= -1;
        }

        // * m이 홀수: 반환값에 현재 x를 곱함
        // (= 비트 변환 시 1: 현재 x값이 포함)
        // 지수 m을 절반으로 => 시간 효율 up
        // x 자체를 거듭제곱 => 시간 효율 up
        double p = 1.0; // 곱셈은 1로 시작
        while (m > 0) {
            if (m % 2 == 1) {
                p *= x; // 비트 1: x 포함
            }
            x *= x;
            m /= 2; // 비트 다음 자리로 이동
        }
        return p;
    }
    // 시간복잡도 O(logn), 공간복잡도 O(1)
}
class Solution {
    // n을 1or2씩 => 이전값(i-1혹은i-2)의 합
    public int climbStairs(int n) {
        // 배열을 써봤더니 공간복잡도 O(n)이었음
        // 배열의 값을 int 변수로 변경
        if (n == 1) {
            return n;
        }
        int one = 1;
        int two = 2; // 2가지: (1,1), (2)
        for (int i = 3; i < n + 1; i++) {
            int curr = one + two;
            one = two;
            two = curr;
        }
        return two; // 최종 도달 경우의 수
    }
}
class Solution {
    public boolean isHappy(int n) {
        Set<Integer> h = new HashSet<>(); // 중복 체크
        while (!h.contains(n)) {
            h.add(n);
            int sum = 0; // 모든 제곱 합
            int tmp = n; // 10으로 나눌 몫
            // 몫이 0 될 때까지 10으로 나누기
            while (tmp > 0) {
                int each = tmp % 10;
                sum += (each * each);
                tmp /= 10;
            }
            n = sum; // contains 조건 확인용
            if (n == 1) {
                return true;
            }
        }
        return false;
    }
}
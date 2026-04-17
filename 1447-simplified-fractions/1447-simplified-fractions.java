class Solution {
    public List<String> simplifiedFractions(int n) {
        // 기약분수 = 최대공약수(GCD)로 나눈 분수
        // 이 문제는 0, 1, 과분수 포함 안 됨: u < d 조건 필요
        List<String> l = new ArrayList<>();
        for (int d = 1; d <= n; d++) {
            for (int u = 1; u < d; u++) {
                if (getGcd(u, d) == 1) {
                    l.add(u + "/" + d);
                }
            }
        }
        return l;
    }

    // 최대공약수 구하기 (유클리드 호제법)
    // 과분수가 아니어도 앞뒤가 바뀔 뿐이어서 ok
    private int getGcd(int up, int down) {
        if (up % down == 0) {
            return down;
        }
        return getGcd(down, (up % down));
    }
}
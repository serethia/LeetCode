class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
        // 동일 원소 개수의 GCD 구하기
        // GCD > 1이면 T, 아니면 F
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int i = 0; i < deck.length; i++) {
            cnt.put(deck[i], cnt.getOrDefault(deck[i], 0) + 1); // ++로 쓰면 type 에러 뜸
        }

        int gcd = cnt.get(deck[0]); // 첫 카운트로 초기화
        for (int eachCnt : cnt.values()) {
            gcd = getGcd(gcd, eachCnt); // 각 카운트의 GCD 탐색
        }
        return gcd > 1;
    }

    private int getGcd(int a, int b) {
        if (a % b == 0) {
            return b;
        }
        return getGcd(b, a % b);
    }
}
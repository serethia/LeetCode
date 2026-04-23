class Solution {
    // 연속되는 원소들의 최대공약수가 k인 부분배열 수
    public int subarrayGCD(int[] nums, int k) {
        int subs = 0;
        for (int i = 0; i < nums.length; i++) {
            int gcd = 0;
            for (int j = i; j < nums.length; j++) {
                gcd = findGcd(gcd, nums[j]);
                if (gcd == k) {
                    // k 만족할 때만 개수 증가
                    subs++;
                } else if (gcd < k) {
                    // "최대"공약수여서 k보다 작으면 조건 충족 불가능
                    break;
                }
            }
        }
        return subs;
    }

    private int findGcd(int a, int b) {
        // b >= a일 때 앞뒤 뒤집어서 재귀: 스택 오버플로우
        // => 유클리드 호제법으로 작성
        while (b != 0) {
            int tmp = (a % b);
            a = b;
            b = tmp;
        }
        return a;
        // 재귀: 공간복잡도 O(log(max(nums)))
        // => 반복문으로 변경: 공간복잡도 O(1)
        // if (b == 0) {
        // return a;
        // }
        // return findGcd(b, (a % b));
    }
}
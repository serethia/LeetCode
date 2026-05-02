class Solution {
    // 이 문제는 n에 0과 음수가 없지만 있다고 고려해보자
    public int hammingWeight(int n) {
        // 비트연산자 >>>: 부호 무시, 0으로 채움
        // 비트연산자 & (and): 둘 다 1일 때만 1
        int ones = 0;

        // n >>> 1로 1칸 우측 이동시킨 뒤
        // n & 1을 카운트에 더해도 되고,
        // while(n != 0){
        //     ones += (n & 1);
        //     n = n >>> 1;
        // }

        // n & (n - 1)로 현존하는 1 중 
        // 마지막 1만 제거하며 카운트 올려도 됨!
        // 마지막 1 빼면 &의 공통 부분이 없어서 
        // 자동으로 n이 0이 되어 while 종료!
        // 음수도 적용 가능! 0 될 때까지 반복
        while (n != 0) {
            ones++;
            n = n & (n - 1);
        }
        return ones;
    }

    // 이 풀이도 되지만 문제가 원하는 건 비트연산자!
    // public int hammingWeight(int n) {
    // int ones = 1; // 맨 앞 1
    // while (n > 0) {
    // if (n % 2 == 1) {
    // ones++;
    // }
    // n /= 2;
    // }
    // return ones;
    // }
}
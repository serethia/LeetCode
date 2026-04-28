class Solution {
    // Arrays.sort로 정렬: 비효율적
    // boolean 변수나 cnt 변수: 비효율적
    // 3회 or 1회 => 비트연산자로 (출현 횟수 % 3) 활용
    // ^ (XOR): 같으면 0, 다르면 1 => On/Off
    // & (AND): 둘 다 1이면 1
    // ~ (NOT): 비트 반전 (0 <=> 1)
    public int singleNumber(int[] nums) {
        int once = 0; // 1회: 1, 그 외: 0
        int twice = 0; // 2회: 1, 그 외: 0
        // XOR(2회까지만 비교 가능)을 1회 once, 
        // 2회 twice로 나눠 3회까지 비교 가능
        for (int i = 0; i < nums.length; i++) {
            // 동시 갱신 X: 등장 1,2회 둘 다 중복 계산될 위험
            // tmp1으로 once 갱신한 후에 tmp2로 twice 갱신해야
            int tmp1 = (nums[i] ^ once); // 1번 등장한 비트: 스위치 on
            once = tmp1 & (~twice); // 2번 등장한 비트: 제거

            int tmp2 = (nums[i] ^ twice); // 2번 등장한 비트: 스위치 on
            twice = tmp2 & (~once); // 1번 등장한 비트: 제거
        }
        // 3번 등장한 비트는 자동 제거 (once, twice 모두 0이 됨)
        return once; // 1번 등장한 비트만 반환
    }
}
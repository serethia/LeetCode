class Solution {
    // 선형 시간 복잡도 + 상수 공간 복잡도
    // Arrays.sort(nums): 시간 O(nlogn), 공간 O(logn)
    // => 비트마스크 활용: ^ (XOR)
    // 비트 단위에서 같으면 0, 다르면 1인 성질 이용
    // (1) 같은 값끼리 xor = 0 (짝수 개의 쌍 지워짐)
    // (2) 0과 xor = 그 숫자 그대로
    // (3) 여러 번 중첩: 순서 무관
    public int singleNumber(int[] nums) {
        int once = 0;
        for (int i = 0; i < nums.length; i++) {
            once ^= nums[i];
        }
        return once;
    }
}
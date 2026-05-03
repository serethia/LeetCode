class Solution {
    // 공통 prefix를 찾아 10진수로 반환할 것
    public int rangeBitwiseAnd(int left, int right) {
        while (right > left) {
            right = right & (right - 1);
        }
        return right;
    }
}
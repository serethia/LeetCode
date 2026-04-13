class Solution {
    // String으로 바꾸지 않고 판단: 뒤집은 숫자 활용 (10으로 나눈 몫과 나머지)
    public boolean isPalindrome(int x) {
        // 앞의 -, 뒤의 0: F
        if (x < 0 || (x != 0 && x % 10 == 0)) {
            return false;
        }
        // 한 자리(0 포함): T
        if (x < 10) {
            return true;
        }

        // 절반까지만 비교 (전체 뒤집은 숫자와 비교하기보다 효율적)
        int y = 0; // 절반만 뒤집은 숫자
        while (x > y) {
            y = (10 * y + (x % 10)); // 10 곱해서 다음 자리 준비하고 10으로 나눈 나머지를 더함
            x /= 10; // y로 옮긴 마지막 자리 버림
        }

        // 비교 결과 T/F를 바로 반환
        return x == y || x == (y / 10); // 자릿수 다르면 10으로 나눈 값을 비교 (정중앙 제외)
    }
}
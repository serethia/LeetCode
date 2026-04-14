class Solution {
    public int[] plusOne(int[] digits) {
        // 전체 자릿수 증가할 수도: 새 int[] 생성
        int last = digits.length - 1;
        for (int i = last; i >= 0; i--) {
            // 9 => 1,0의 경우를 밖으로 빼기
            if (digits[i] != 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }

        // 모두 9 => 1,0,0... => 길이 1 증가한 배열
        int[] largerDigits = new int[last + 2]; // 나머지 자리는 0
        largerDigits[0] = 1; // 첫 자리만 1
        return largerDigits;
    }
}
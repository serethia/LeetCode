class Solution {
    // 0 0 = 0, 자리올림 0
    // 0 1 = 1, 자리올림 0 (1 0도 마찬가지)
    // 1 1 = 0, 자리올림 1
    // 비트를 char로 직접 넣기 (X)
    // 두 비트 합을 2로 나누기 (O)
    // curr: 합%2, upper: 합/2
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        // 오=>왼 추가
        int adx = a.length() - 1;
        int bdx = b.length() - 1;
        int upper = 0; // 자리 올림
        while (adx >= 0 || bdx >= 0 || upper > 0) {
            int curr = upper; // 두 비트 합 + 자리 올림
            if (adx >= 0) {
                curr += a.charAt(adx) - '0';
                adx--;
            }
            if (bdx >= 0) {
                curr += b.charAt(bdx) - '0';
                bdx--;
            }
            sb.append(curr % 2);
            upper = curr / 2;
        }
        return sb.reverse().toString(); // 왼=>오 반환
    }
}
class Solution {
    // chars 자체를 갱신: 문자와 그 개수(자리수 당 한 칸) 번갈아 표현한 문자열의 char들
    // 문자 개수 문자 개수 ... (2개 이상만 개수 표시)
    // 1개면 1표시X, (2 이상) n개면 n표시O
    // constant extra space: 포인터 변수 활용
    // 압축된 문자열 길이 반환: 입력용 포인터 필요
    // 갱신용 1개, 비교용 2개 => 총 3개 필요!
    public int compress(char[] chars) {
        int comp = 0; // 갱신용 포인터
        int st = 0; // 비교용 포인터1
        while (st < chars.length) {
            // [1] 문자 입력 & 동일 구간 탐색
            chars[comp++] = chars[st]; // 현재 문자 입력
            int ed = st; // 비교용 포인터2
            // 문자 같을 동안 포인터2 이동 (구간 탐색)
            while (ed < chars.length && chars[ed] == chars[st]) {
                ed++;
            }

            // [2] 2개 이상은 개수 추가 입력
            int df = (ed - st); // ed와 st의 차이 = 중복 글자 개수
            if (df > 1) {
                // * (char) int값 + '0';은
                // 1자리일 때만 int=>char 가능 (비추천) *
                String diff = String.valueOf(df); // 중복 개수를 문자열로
                for (int c = 0; c < diff.length(); c++) {
                    chars[comp++] = diff.charAt(c); // 숫자 자릿수마다 입력
                }
            }
            st = ed; // 다음 문자로 이동
        }
        return comp; // 압축 길이 = 갱신 포인터 반환
    }
}
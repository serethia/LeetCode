class Solution {
    // num을 den으로 나누되 반복구간은 괄호로 묶기
    public String fractionToDecimal(int numerator, int denominator) {
        StringBuilder sb = new StringBuilder();
        if ((numerator < 0 && denominator > 0) || (numerator > 0 && denominator < 0)) {
            sb.append("-"); // 음수 부호 추가
        }
        // int인 상태로 -1 곱하면 범위 터질 수 있어서
        // long으로 변환 후 양수화
        long numeratorL = numerator;
        if (numeratorL < 0) {
            numeratorL *= -1;
        }
        long denominatorL = denominator;
        if (denominatorL < 0) {
            denominatorL *= -1;
        }

        sb.append(numeratorL / denominatorL); // 몫 부분
        if (numeratorL % denominatorL == 0) {
            return sb.toString(); // 나머지 없으면 바로 반환
        }

        sb.append(".");
        Map<Long, Integer> repeat = new HashMap<>(); // 반복 구간 확인용
        long under = (numeratorL % denominatorL); // 나머지(소수) 부분
        while (under != 0) {
            if (repeat.containsKey(under)) {
                sb.insert(repeat.get(under), "("); // insert: 해당 자리에 삽입
                sb.append(")");
                break; // 반복 구간 무한 루프 방지 & 반환
            }
            repeat.put(under, sb.length()); // 맵에 시작 위치 추가 (append 전이므로 length()-1가 아니라 length()로)
            under *= 10; // 한 자리씩 올리기
            sb.append(under / denominatorL); // sb에 한 자리 추가
            under %= denominatorL; // 나머지 다시 구하기
        }
        return sb.toString();
    }
}
class Solution {
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        // treemap 내림차순 정렬
        TreeMap<Integer, String> map = new TreeMap<>(Comparator.reverseOrder()) {
            {
                put(1, "I");
                put(5, "V");
                put(10, "X");
                put(50, "L");
                put(100, "C");
                put(500, "D");
                put(1000, "M");
                put(4, "IV");
                put(9, "IX");
                put(40, "XL");
                put(90, "XC");
                put(400, "CD");
                put(900, "CM");
            }
        };

        // entry = 키-값 쌍
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            while (num >= entry.getKey()) {
                // 키 integer 빼기
                num -= entry.getKey();
                // 값 string 추가
                sb.append(entry.getValue());
            }
        }

        // System.out.println();의 경우 string으로 자동 변환됨
        return sb.toString();
    }
}
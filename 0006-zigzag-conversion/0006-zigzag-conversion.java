class Solution {
    public String convert(String s, int numRows) {
        // 1줄: 바로 반환
        if (numRows < 2) {
            return s;
        }

        // row별 stringbuilder 배열 생성
        StringBuilder[] sbs = new StringBuilder[numRows];
        for (int i = 0; i < sbs.length; i++) {
            // 각 stringbuilder 초기화
            sbs[i] = new StringBuilder();
        }

        boolean fall = true; // 세로로 하강
        int r = 0; // 현위치 row
        for (int i = 0; i < s.length(); i++) {
            // 맨 끝 행 도달 시 fall 전환
            if (r == numRows - 1) {
                fall = false;
            } else if (r == 0) {
                fall = true;
            }
            // fall에 따른 row 변화만 반영
            if (fall) {
                sbs[r++].append(s.charAt(i));
            } else {
                sbs[r--].append(s.charAt(i));
            }
        }

        // 정답용 stringbuilder
        StringBuilder sb = new StringBuilder();
        for (int row = 0; row < numRows; row++) {
            sb.append(sbs[row]);
        }
        return sb.toString();
    }
}
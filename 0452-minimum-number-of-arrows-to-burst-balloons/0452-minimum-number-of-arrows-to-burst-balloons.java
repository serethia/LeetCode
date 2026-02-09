class Solution {
    public int findMinArrowShots(int[][] points) {
        // int 기준 정렬 => Comparator.comparingInt
        Arrays.sort(points, Comparator.comparingInt(o -> o[0]));
        // 최솟값 끝점 >= 현재 시작점: merge
        int cnt = 1; // 반환값
        int ed = points[0][1]; // 끝점
        for (int i = 1; i < points.length; i++) {
            if (ed >= points[i][0]) {
                // merge
                ed = Math.min(ed, points[i][1]);
            } else {
                // 새 구간
                ed = points[i][1];
                cnt++;
            }
        }
        return cnt;
    }
}
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        // 예외 처리
        if (intervals.length == 0) {
            return new int[][] { newInterval };
        }

        List<int[]> itv = new ArrayList<>();
        boolean done = false; // newInterval 삽입되었는지
        for (int i = 0; i < intervals.length; i++) {
            int[] curr = intervals[i];
            if (curr[0] <= newInterval[1] && curr[1] >= newInterval[0]) {
                // 머지 O
                // newInterval에 최대 범위 누적만
                newInterval[0] = Math.min(newInterval[0], curr[0]);
                newInterval[1] = Math.max(newInterval[1], curr[1]);
            } else if (!done && newInterval[1] < curr[0]) {
                // 머지 X
                // 오른쪽에 해당하는 curr 첫 등장
                // 지금까지 누적한 newInterval 추가
                done = true;
                itv.add(newInterval);
                // 현재 curr도 추가
                itv.add(curr);
            } else {
                // 머지 X, 나머지 경우: curr 추가
                itv.add(curr);
            }
        }
        // 머지 X, 맨 오른쪽: 추가
        if (!done) {
            itv.add(newInterval);
        }
        return itv.toArray(new int[itv.size()][]);
    }
}
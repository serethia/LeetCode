class Solution {
    public int[][] merge(int[][] intervals) {
        // 개수 불확실: 리스트 활용
        List<int[]> itv = new ArrayList<>();
        // 첫 값 기준 오름차순 (Comparator)
        // Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]); 도 가능, but overflow 우려
        // 기본형은 comparingInt/Long/Double, 그 외 object는 comparing
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

        // merge 가능 구간 확인
        int st = intervals[0][0];
        int ed = intervals[0][1];
        for (int mid = 1; mid < intervals.length; mid++) {
            if (ed >= intervals[mid][0]) {
                // st 1번째 값 >= mid 0번째 값: merge
                ed = Math.max(ed, intervals[mid][1]);
            } else {
                // 리스트에 최대 구간 추가
                itv.add(new int[] { st, ed });
                // merge 불가능: 다음 구간으로
                st = intervals[mid][0];
                ed = intervals[mid][1];
            }
            // 여기에 itv.add(new int[] { st, ed }); 작성해버리면 겹치는 중간 구간도 추가되어서 X
        }
        // 리스트에 아직 안 들어간 마지막 구간 추가
        itv.add(new int[] { st, ed });
        // 리스트를 2차원 배열로 반환
        return itv.toArray(new int[itv.size()][]);
    }
}
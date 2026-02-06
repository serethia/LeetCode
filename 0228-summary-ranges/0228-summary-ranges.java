class Solution {
    public List<String> summaryRanges(int[] nums) {
        // nums[i]값 범위 주의 => long
        // [1] 연속되는 구간 => st, ed 포인터
        // [2] 다르면 "a->b", 같으면 "a" 표기
        List<String> list = new ArrayList<>();
        for (int st = 0; st < nums.length; st++) {
            long a = nums[st];
            long b = nums[st];
            // 값의 연속성 확인
            for (int ed = (st + 1); ed < nums.length; ed++) {
                if (nums[ed] != b + 1) {
                    break;
                }
                b = nums[ed]; // 끝값 갱신
                st = ed; // 값 비교를 위해 시작점 이동
            }
            // 리스트 표기 방식
            if (a != b) {
                list.add(a + "->" + b);
            } else {
                list.add(String.valueOf(a)); // (object, char 제외) 문자열 변환
            }
        }
        return list;
    }
}
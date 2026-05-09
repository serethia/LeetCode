class Solution {
    // O(logn) 시간복잡도: st, ed 각각 이분탐색
    // 슬라이딩윈도우나 선형탐색 섞으면 비효율적
    public int[] searchRange(int[] nums, int target) {
        // st: 첫 target 이상 값인 인덱스
        int stSt = 0;
        int stEd = nums.length - 1;
        int st = 0;
        while (stSt <= stEd) {
            int stMid = stSt + (stEd - stSt) / 2;
            if (nums[stMid] >= target) {
                stEd = stMid - 1;
            } else {
                stSt = stMid + 1;
            }
        }
        st = stSt;

        // ed: 첫 target 초과 값인 인덱스
        int edSt = 0;
        int edEd = nums.length - 1;
        int ed = 0;
        while (edSt <= edEd) {
            int edMid = edSt + (edEd - edSt) / 2;
            if (nums[edMid] >= target + 1) {
                edEd = edMid - 1;
            } else {
                edSt = edMid + 1;
            }
        }
        ed = edSt - 1; // 초과 인덱스 앞자리

        // st가 배열 바깥으로 나가지는 않았는가,
        // 첫 target 이상 값인 인덱스 st의 
        // 실제 값이 제대로 target과 일치하는가
        return (st >= nums.length || nums[st] != target) ? new int[] { -1, -1 } : new int[] { st, ed };
        // nums.length == 0 or 1도 처리 가능
    }
    // * 권장: 이 코드에서 투포인터를 뺀 이분탐색
    // 이라고 나오지만 정확히는 투포인터가 아님!
    // => 이 코드는 맞는 코드(이분탐색)로 생각하자
}
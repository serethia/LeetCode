class Solution {
    // 좌측으로 회전(순환)하는 정렬된 배열
    // unique (중복X) => 이상/이하(X), 초과/미만(O)
    // 시간복잡도 O(logn): 이분 탐색
    public int search(int[] nums, int target) {
        // * 주의) st, ed는 값이 아니라 인덱스!
        // st < ed 조건: 답을 하나로 수렴할 때
        // (마지막 후보가 답이 되도록: 회전 기준점)
        // st <= ed 조건: 실제 값을 탐색할 때
        // (마지막 후보까지 체크: target과 일치)
        int st = 0;
        int ed = nums.length - 1;
        int rotate = 0;
        // 길이 1인 경우: st == ed에 포함
        // [1] 제일 작은 값 인덱스 rotate 탐색
        while (st < ed) {
            rotate = st + (ed - st) / 2;
            if (nums[rotate] > nums[ed]) {
                // 우측 구간
                st = rotate + 1;
            } else {
                // 좌측 구간
                // (rotate - 1)이 아닌 건 
                // rotate가 답일 수도 있어서.
                ed = rotate;
            }
        }

        // st == ed면 회전 시작점 도출 가능
        rotate = st;
        // 이후 이분 탐색을 위한 인덱스 초기화
        st = 0;
        ed = nums.length - 1;

        // [2] rotate 기준 앞/뒤 이분 탐색
        if (target <= nums[ed] && target >= nums[rotate]) {
            // [2-1] 뒷 구간 (rotate 포함)
            st = rotate;
        } else {
            // [2-2] 앞 구간
            ed = rotate - 1;
        }
        while (st <= ed) {
            int mid = (st + ed) / 2;
            if (nums[mid] == target) {
                // [3] 있으면 그 인덱스 반환
                return mid;
            } else if (nums[mid] < target) {
                // 오른쪽 구간으로 좁히기
                st = mid + 1;
            } else {
                // 왼쪽 구간으로 좁히기
                ed = mid - 1;
            }
        }
        // [3'] 없으면 -1 반환
        return -1;
    }

    // * 권장 코드: 투 포인터 없이 이분 탐색
    // 기존 코드에서 회전 시작점 없앤 코드:
    //public int search(int[] nums, int target) {
    //int st = 0;
    //int ed = nums.length - 1;
    //while(st <= ed){
    //int mid = st + (ed - st)/2;
    //if(nums[mid] == target){
    //return mid;
    //}
    //}
    //if(nums[st] <= nums[mid]){
    // [1] 왼쪽 범위가 완전한 오름차순
    //if(target >= nums[st] && target < nums[mid]){
    //ed = mid - 1; // 좌측 구간
    //} else {
    //st = mid + 1; // 우측 구간
    //}
    //} else {
    // [2] 오른쪽 범위가 완전한 오름차순
    //if(target <= nums[ed] && target > nums[mid]){
    //st = mid + 1; // 우측 구간
    //} else {
    //ed = mid - 1; // 좌측 구간
    //}
    //}
    //return -1; // 없으면 -1 반환
    //}
}
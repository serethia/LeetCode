class Solution {
    // * median (중앙값)
    // 1. 홀수 개: 정중앙값
    // 2. 짝수 개: 중앙의 두 값의 평균값
    // 두 배열의 파티션으로만 이분탐색 (머지X)
    // 왼쪽 파티션 최댓값 <= 오른쪽 파티션 최솟값
    // * 시간복잡도: O(log(min(M,N)))
    // * 공간복잡도: O(1)
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // 짧은 배열 기준 탐색 (큰 배열 자동 결정해 시간 절약)
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        double med = 0.0;
        int tot = nums1.length + nums2.length; // 총 원소 수
        int lft = (tot + 1) / 2; // 왼쪽 원소 수 (홀짝 고려 O)
        // * 홀수일 때: 왼쪽 = 오른쪽 + 1개
        // * 짝수일 때: 왼쪽 개수 = 오른쪽 개수
        // 2번째 배열 왼쪽 개수 = (lft - 1번째 배열 왼쪽 개수)
        int st = 0;
        int ed = nums1.length;
        // 모든 파티션 검사를 위해 st == ed도 기준에 포함
        while (st <= ed) {
            int first = st + (ed - st) / 2; // 1번째 배열 파티션 위치
            int second = lft - first; // 2번째 배열 파티션 위치
            // 각 파티션 좌 최댓값, 우 최솟값 구하기
            int firstLft = (first >= 1) ? nums1[first - 1] : Integer.MIN_VALUE;
            int firstRgt = (first <= nums1.length - 1) ? nums1[first] : Integer.MAX_VALUE;
            int secondLft = (second >= 1) ? nums2[second - 1] : Integer.MIN_VALUE;
            int secondRgt = (second <= nums2.length - 1) ? nums2[second] : Integer.MAX_VALUE;
            // 모든 좌 최댓값 <= 우 최솟값인지 확인
            if (firstLft <= secondRgt && secondLft <= firstRgt) {
                if (tot % 2 == 0) {
                    // 짝수 개
                    med = (Math.max(firstLft, secondLft) + Math.min(firstRgt, secondRgt)) / 2.0;
                } else {
                    // 홀수 개
                    med = Math.max(firstLft, secondLft);
                }
                return med;
            } else if (firstLft > secondRgt) {
                // 파티션1 왼쪽으로 (2번째도 자동 이동)
                // first는 틀렸다는 전제라서 제외
                ed = first - 1;
            } else {
                // secondLft > firstRgt:
                // 파티션1 오른쪽으로 (2번째도 자동 이동)
                // first는 틀렸다는 전제라서 제외
                st = first + 1;
            }
        }
        return med;
    }
    // 두 array를 merge하고 median 이분탐색 시
    // 복잡도가 O(m+n)이 되어버려서 비효율적
    // => merge 없이 파티션 이분탐색만으로 구현!
    // => 시간복잡도 O(log(m+n)) 만족!
}
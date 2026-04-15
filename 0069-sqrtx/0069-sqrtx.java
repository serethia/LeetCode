class Solution {
    // 단순 for문 + while문: 시간 초과
    // 이중 for문(st,ed 1칸씩 이동): 시간 초과
    // 중앙값을 양 끝에서부터 좁혀 오며 탐색
    public int mySqrt(int x) {
        // 1도 예외 처리 포함해줘야 함
        if (x == 0 || x == 1) {
            return x;
        }

        int sq = 0; // 제곱근
        int st = 1; // 왼쪽 포인터 값
        int ed = x / 2; // 오른쪽 포인터 값
        while (st <= ed) {
            int md = (st + (ed - st) / 2); // 중앙값
            // md*md는 범위 주의해야 => x/md로
            if (x / md >= md) {
                // 크면 st를 증가 (md도 증가)
                st = md + 1; // md 이전 값 제거
                sq = md; // 답 후보에 갱신
            } else {
                // 작으면 ed를 감소 (md도 감소)
                ed = md - 1; // md 이후 값 제거
            }
        }
        return sq;
    }
}
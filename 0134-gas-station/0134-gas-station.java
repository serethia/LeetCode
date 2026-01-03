class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length; // 주유소 수
        int bg = 0; // 시작 지점
        int curr = 0; // 현재 가스
        int car = 0; // 가스 총합 판단
        for (int i = 0; i < n; i++) {
            curr += (gas[i] - cost[i]);
            car += (gas[i] - cost[i]);
            if (curr < 0) {
                curr = 0;
                bg = i + 1;
                continue;
            }
        }
        if (car >= 0) {
            return bg;
        } else {
            return -1;
        }
    }
}
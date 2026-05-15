class Solution {
    // k개 선택 시 w에서 시작한 최대 자본 반환
    // 현재 자본 >= capital[i] 의 경우만 뽑기
    // 포인터를 둬서 매 반복마다 중복이 없도록 함
    // profits[i] 만큼 현재 자본에 합산 & 반환
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int[][] sets = new int[capital.length][2];
        // 한 쌍으로 저장 (인덱스 연결)
        for (int s = 0; s < capital.length; s++) {
            sets[s][0] = capital[s];
            sets[s][1] = profits[s];
        }
        // capital 기준 오름차순 (comparator)
        Arrays.sort(sets, (c1, c2) -> Integer.compare(c1[0], c2[0]));
        // profits 기준 내림차순 우선순위 큐
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int idx = 0; // 포인터 (진행완료 중복 제거)
        // 총 k번 뽑기
        for (int t = 0; t < k; t++) {
            // w >= capital인 profits만 pq에 추가
            while (idx < capital.length && w >= sets[idx][0]) {
                pq.offer(sets[idx][1]);
                idx++;
            }
            // pq가 비면 바로 종료
            if (pq.isEmpty()) {
                break;
            }
            w += pq.poll(); // 최대 수익 합산
        }
        return w;
    }
}
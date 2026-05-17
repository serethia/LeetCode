class MedianFinder {
    // pq 활용: but 1개로는 불가능 (비효율적).
    // pq 오름차순용 & 내림차순용 해서 총 2개!
    // poll 쓰면 구조 안이 바뀌므로 peek를 쓰자.
    PriorityQueue<Integer> pqL; // 내림차순 정렬 (왼쪽 절반)
    PriorityQueue<Integer> pqR; // 오름차순 정렬 (오른쪽 절반)

    // * 총 개수 (홀짝 판단용) n: 굳이 필요 X
    // pqL.size() == pqR.size()면 짝수, 그 외는 홀수로!

    public MedianFinder() {
        pqL = new PriorityQueue<>(Collections.reverseOrder());
        pqR = new PriorityQueue<>();
    }

    public void addNum(int num) {
        // 무조건 왼쪽에 추가해 줌
        pqL.offer(num);
        // 전체로 봤을 때 오름차순 정렬 어긋났다면
        while (!pqR.isEmpty() && pqL.peek() > pqR.peek()) {
            // 왼쪽에 넣은 값을 오른쪽으로 이동
            pqR.offer(pqL.poll());
        }

        // offer한 후에 pq 간 개수 차 조정
        if (pqL.size() > pqR.size() + 1) {
            // R개수+1 < L개수: 1개 이동 (개수 차 최대 1로)
            pqR.offer(pqL.poll());
        } else if (pqR.size() > pqL.size() + 1) {
            // L개수+1 < R개수: 1개 이동 (개수 차 최대 1로)
            pqL.offer(pqR.poll());
        }
    }

    // 홀수 개: 중앙값
    // 짝수 개: 가운데 두 값의 평균값
    public double findMedian() {
        if (pqL.size() == pqR.size()) {
            // 짝수 개일 때
            return (pqL.peek() + pqR.peek()) / 2.0;
            // * 값/2 : int로 반환됨 주의!
        }
        // 홀수 개일 때
        return pqL.size() > pqR.size() ? pqL.peek() : pqR.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
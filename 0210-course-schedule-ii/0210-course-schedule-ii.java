class Solution {
    // Kahn: BFS 기반 위상정렬 (indegree 0부터 제거하면서 순서 생성)
    // indegree = 진입차수: 현재 노드로 들어오는 간선 개수
    // 연결된 노드들의 indegree (선행 대상 개수) 1씩 감소시켜 0이 된 노드들을 그 때마다 큐에 넣고, 그 때마다 꺼낸 현재 노드를 반환할 array에 추가
    // indegree가 0인 노드가 없는데도 아직 남아있는 노드가 존재하는 경우: 사이클 존재 (서로에게 진입함)
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Queue<Integer> q = new LinkedList<>(); // BFS용 큐
        List<Integer>[] l = new ArrayList[numCourses]; // 그래프용 리스트
        for (int i = 0; i < numCourses; i++) {
            l[i] = new ArrayList<>();
        }
        int[] indegree = new int[numCourses]; // 진입 차수 저장 (인접 노드만 변경)
        for (int i = 0; i < prerequisites.length; i++) {
            // a => b
            int b = prerequisites[i][0];
            int a = prerequisites[i][1];
            l[a].add(b); // a의 인접 노드 리스트에 추가
            indegree[b]++; // b의 진입 차수 증가
        }

        // 선행 대상 0인 노드만 큐에 먼저 추가
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        List<Integer> order = new ArrayList<>(); // 반환용 순서 리스트 (총 개수 모름)
        while (!q.isEmpty()) {
            int curr = q.poll(); // 현재 노드
            order.add(curr); // 현재 노드 정답 리스트에 추가
            int n = l[curr].size(); // 인접 리스트 크기
            // 인접 리스트 탐색
            for (int i = 0; i < n; i++) {
                int tmp = l[curr].get(i);
                // 인접 노드만 진입 차수 1 감소
                if (--indegree[tmp] == 0) {
                    q.offer(tmp);
                }
            }
        }

        // 모든 노드를 거쳐 가지 못할 경우
        int total = order.size(); // 총 개수
        if (total < numCourses) {
            return new int[0]; // 빈 array 반환 
            // *주의* return []; 표현은 JavaScript, Python 표현임
        }

        // int[]로 형변환
        int[] orderList = new int[total];
        for (int i = 0; i < total; i++) {
            orderList[i] = order.get(i);
        }
        return orderList;
    }
}
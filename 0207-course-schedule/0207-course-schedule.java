class Solution {
    private Map<Integer, List<Integer>> map; // 필요 노드 목록 저장
    private Set<Integer> set; // 탐색 경로 저장
    boolean[] visited; // 방문 여부
    boolean ans; // 반환 T/F

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        map = new HashMap<>();
        set = new HashSet<>();
        visited = new boolean[numCourses];
        ans = true;
        for (int i = 0; i < prerequisites.length; i++) {
            int tmp = prerequisites[i][1]; // 선행 노드
            if (!map.containsKey(tmp)) {
                map.put(tmp, new ArrayList<>());
            }
            map.get(tmp).add(prerequisites[i][0]);
        }

        // 모든 노드 체크
        for (int i = 0; i < numCourses; i++) {
            // F면 바로 반환
            if (!ans) {
                return ans;
            }
            find(i);
        }
        return ans;
    }

    private void find(int curr) {
        // 현재 탐색 경로에서 사이클 발견 = F
        if (set.contains(curr)) {
            ans = false;
            return;
        }

        // 이미 방문함 (사이클 없음 탐색 완료) = T
        if (visited[curr]) {
            return;
        }

        // 탐색 경로에 없었음 & 아직 미방문일 경우
        set.add(curr); // 탐색 경로에 임시 추가
        // DFS 재귀 탐색: 연결된 노드들도 안전한지 체크
        if (map.containsKey(curr)) {
            int n = map.get(curr).size();
            for (int i = 0; i < n; i++) {
                // 탐색 도중 사이클 발견 시 바로 탐색 종료
                if (!ans) {
                    return;
                }
                find(map.get(curr).get(i));
            }
        }
        visited[curr] = true; // 방문 완료
        set.remove(curr); // 탐색 경로에서 제거
    }
}
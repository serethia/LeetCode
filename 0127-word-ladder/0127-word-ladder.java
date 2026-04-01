class Solution {
    // visited => set 활용 (중복,방문처리)
    // diff함수 => 1글자 차이인 모든 경우의 수를 직접 만들어 set.contains()로 비교 후 원상복구
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // endWord 없으면 0
        Set<String> s = new HashSet<>(wordList);
        if (!s.contains(endWord)) {
            return 0;
        }

        // BFS 레벨
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        s.remove(beginWord);
        int trans = 1; // 최소 단어 개수
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String str = q.poll();
                char[] each = str.toCharArray();
                for (int j = 0; j < each.length; j++) {
                    char curr = each[j]; // 원본 저장해 두기
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c != curr) {
                            each[j] = c; // 임시로 넣고
                            String tmp = new String(each); // 임시 문자열 생성
                            if (s.contains(tmp)) {
                                if (tmp.equals(endWord)) {
                                    return (trans + 1); // 도달 시 개수 반환
                                }
                                q.offer(tmp); // 변환 가능
                                s.remove(tmp); // 방문처리       
                            }
                        }
                    }
                    each[j] = curr; // 원상복구
                }
            }
            trans++;
        }
        return 0;
    }
}
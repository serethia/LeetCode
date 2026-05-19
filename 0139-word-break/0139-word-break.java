class Solution {
    // 소문자만, 길이 둘 다 1 이상, 중복 사용 가능
    // 단어 일치 시 시작 => 끝 인덱스 도달 가능?
    // 일반 dp에 hashset로 탐색 시간 효율 높임!
    // (분석에서는 trie도 써서 prefix 검사하라고도 함)
    // 이 코드에서는 hashset까지만 쓴 dp로 작성함
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        boolean[] each = new boolean[s.length() + 1];
        each[0] = true; // true로 시작
        for (int st = 0; st < s.length(); st++) {
            // 도달 가능한 곳인지 체크
            if (each[st]) {
                // substring(포함, 미포함) 활용
                for (int ed = st + 1; ed < s.length() + 1; ed++) {
                    String str = s.substring(st, ed);
                    // 있다면 도달 인덱스 T 처리
                    if (dict.contains(str)) {
                        each[ed] = true;
                    }
                }
            }
        }
        return each[s.length()];
    }
}

// * 일반적인 string dp 코드:
// 이 코드도 정답이지만, 시간 효율이 위 코드보다 낮음
//class Solution {
//public boolean wordBreak(String s, List<String> wordDict) {
// str.startsWith(string, idx) 활용
// str의 idx번째가 string으로 시작하는지
//boolean[] each = new boolean[s.length() + 1];
//each[0] = true; // true로 시작
//for (int i = 0; i < s.length(); i++) {
//if (each[i]) {
//for (int j = 0; j < wordDict.size(); j++) {
//String str = wordDict.get(j);
// 일치 여부
//if (s.startsWith(str, i)) {
// 도달 인덱스 T 처리
//each[i + str.length()] = true;
//}
//}
//}
//}
// * 검사 시 each[s.length()-1] 아님! 
// 이 dp는 글자 자체가 아니라 맨앞, 맨뒤 포함한 
// 글자 간 간격 단위로 판단하는 거라서.
// 그래서 each[i+str.length()]로 이미 진행했음.
//return each[s.length()]; // 마지막만 검사
//}
//}
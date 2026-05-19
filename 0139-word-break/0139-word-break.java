class Solution {
    // 소문자만, 길이 둘 다 1 이상, 중복 사용 가능
    // 단어 일치 시 시작 => 끝 인덱스 도달 가능?
    public boolean wordBreak(String s, List<String> wordDict) {
        // str.startsWith(string, idx) 활용
        // str의 idx번째가 string으로 시작하는지
        boolean[] each = new boolean[s.length() + 1];
        each[0] = true; // true로 시작
        for (int i = 0; i < s.length(); i++) {
            if (each[i]) {
                for (int j = 0; j < wordDict.size(); j++) {
                    String str = wordDict.get(j);
                    // 일치 여부
                    if (s.startsWith(str, i)) {
                        // 도달 인덱스 T 처리
                        each[i + str.length()] = true;
                    }
                }
            }
        }
        // * 검사 시 each[s.length()-1] 아님! 
        // 이 dp는 글자 자체가 아니라 맨앞, 맨뒤 포함한 
        // 글자 간 간격 단위로 판단하는 거라서.
        // 그래서 each[i+str.length()]로 이미 진행했음.
        return each[s.length()]; // 마지막만 검사
    }
}
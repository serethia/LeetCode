class Solution {
    public boolean isSubsequence(String s, String t) {
        int len = s.length();
        int text = t.length();
        // 투포인터 (큐는 투포인터보다 비효율적)
        int scurr = 0;
        int tcurr = 0;
        while (scurr < len && tcurr < text) {
            if (s.charAt(scurr) == t.charAt(tcurr)) {
                scurr++;
            }
            tcurr++;
        }
        return scurr == len ? true : false;
    }
}
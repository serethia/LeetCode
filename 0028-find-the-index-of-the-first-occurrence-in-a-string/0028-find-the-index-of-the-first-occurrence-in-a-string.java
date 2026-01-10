class Solution {
    public int strStr(String haystack, String needle) {
        // indexof 못 쓸 경우에는 substring으로 직접 구현
        return haystack.indexOf(needle);
    }
}
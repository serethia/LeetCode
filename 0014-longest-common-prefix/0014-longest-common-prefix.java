class Solution {
    public String longestCommonPrefix(String[] strs) {
        String s = strs[0]; // 첫 단어
        // stringbuilder로 비교해 쌓는 건 복잡도 효율 낮음 => indexof와 substring 사용
        for (int i = 1; i < strs.length; i++) {
            // 해당 글자가 아예 없으면 indexof는 -1을 반환 (< 0은 존재만 하면 허용, != 0은 접두사인 경우만 허용)
            // 접두사이므로 startswith 사용이 더 나음 (원래는 대소문자 통일 필요)
            while (!strs[i].startsWith(s)) {
                // 맨 뒤를 잘라 공통 부분만 남을 때까지 반복 갱신
                s = s.substring(0, s.length() - 1);
            }
        }
        return s;
    }
}
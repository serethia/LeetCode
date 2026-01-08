class Solution {
    public String reverseWords(String s) {
        // stack은 공간복잡도 o(n) => 다른 방법
        // 맨앞뒤 공백 제거 & 연속 공백 포함해서 단어 구분
        String[] str = s.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();
        // 역순으로 배치
        for (int i = str.length - 1; i >= 0; i--) {
            sb.append(str[i]);
            sb.append(" "); // 단어 간 띄어쓰기
        }
        // 본래 System.out.println(sb);에 toString() 포함
        return sb.toString().trim();
    }
}
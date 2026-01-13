class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> text = new ArrayList<>(); // stringbuilder로 저장할 각 줄의 리스트
        for (int st = 0; st < words.length; st++) {
            int ed = findLastIndex(words, maxWidth, st); // 끝 단어 인덱스 탐색
            text.add(justifyLine(words, maxWidth, st, ed)); // 해당 줄 저장
            st = ed; // 시작점 이동
        }
        return text;
    }

    // 줄 가장 마지막 단어에 해당하는 인덱스 찾기
    private int findLastIndex(String[] str, int wd, int start) {
        int end = start + 1;
        int len = str[start].length();
        while (end < str.length && (len + 1 + str[end].length()) <= wd) {
            len += str[end].length() + 1; // 공백 포함
            end++;
        }
        return end - 1; // 길이 초과되기 이전 인덱스
    }

    // 공백까지 추가(양쪽정렬/왼쪽정렬)한 문자열 stringbuilder로 만들어 반환
    private String justifyLine(String[] str, int wd, int start, int end) {
        StringBuilder sb = new StringBuilder();

        // [1] 한 단어: 우측 공백 채우고 바로 반환
        if (start == end) {
            sb.append(str[start]);
            for (int t = 0; t < (wd - str[start].length()); t++) {
                sb.append(" ");
            }
            return sb.toString();
        }

        // [2] 마지막 줄: 좌측정렬해 우측 공백 채워 반환
        if (end == str.length - 1) {
            int tot = 0; // 문자 총 길이
            for (int i = start; i <= end; i++) {
                if (i == end) {
                    sb.append(str[i]);
                    tot += str[i].length();
                    for (int j = 0; j < (wd - tot); j++) {
                        sb.append(" ");
                    }
                } else {
                    sb.append(str[i]).append(" ");
                    tot += (str[i].length() + 1); // 공백 포함
                }

            }
            return sb.toString();
        }

        // [3] 그 외: 양쪽정렬 & 공백 균등 분배해 반환
        int totalWord = 0; // 문자 총 길이
        for (int i = start; i <= end; i++) {
            totalWord += str[i].length();
        }
        int totalSpace = (wd - totalWord); // 공백 총 길이
        int equalSpace = totalSpace / (end - start); // 몫: 공백 균등 분배
        int moreSpace = totalSpace % (end - start); // 나머지: 공백 좌측에 추가
        for (int i = start; i <= end; i++) {
            sb.append(str[i]);
            if (i != end) {
                for (int j = 0; j < equalSpace; j++) {
                    sb.append(" ");
                }
                if (moreSpace > 0) {
                    sb.append(" ");
                    moreSpace--;
                }
            }
        }
        return sb.toString();
    }
}
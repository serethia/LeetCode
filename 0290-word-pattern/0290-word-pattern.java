class Solution {
    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> match = new HashMap<>();
        String[] str = s.split(" ");
        if (pattern.length() != str.length) {
            return false;
        }
        for (int i = 0; i < str.length; i++) {
            char c = pattern.charAt(i);
            if (!match.containsKey(c) && !match.containsValue(str[i])) {
                // 일대일
                match.put(c, str[i]);
            } else if (match.containsKey(c)) {
                // 일대다
                String tmp = match.get(c);
                if (!tmp.equals(str[i])) {
                    return false;
                }
            } else if (match.containsValue(str[i])) {
                // 다대일
                return false;
            }
        }
        return true;
    }
}
class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> iso = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ss = s.charAt(i); // 키
            char tt = t.charAt(i); // 값
            if (!iso.containsKey(ss) && !iso.containsValue(tt)) {
                // 키, 값 둘 다 없을 때 추가
                iso.put(ss, tt);
            } else if (iso.containsKey(ss)) {
                // 키 있을 때 값 1개 넘어가면 F
                char ttmp = iso.get(ss);
                if (ttmp != tt) {
                    return false;
                }
            } else if (iso.containsValue(tt)) {
                // 키는 없고 값만 있을 때 F (다대일)
                return false;
            }
        }
        return true;
    }
}
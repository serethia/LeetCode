class Solution {
    List<List<Integer>> l;

    public List<List<Integer>> combine(int n, int k) {
        l = new ArrayList<>();
        comb(1, n, k, new ArrayList<>());
        return l;
    }

    private void comb(int st, int n, int k, List<Integer> tmp) {
        if (tmp.size() == k) {
            l.add(new ArrayList<>(tmp));
            return;
        }

        for (int i = st; i <= n; i++) {
            tmp.add(i);
            comb(i + 1, n, k, tmp);
            tmp.remove(tmp.size() - 1);
        }
    }
}
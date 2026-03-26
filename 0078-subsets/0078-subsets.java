class Solution {
    List<List<Integer>> list; // 부분집합 리스트

    public List<List<Integer>> subsets(int[] nums) {
        list = new ArrayList<>();
        back(new ArrayList<>(), nums, 0); // 백트래킹
        return list;
    }

    private void back(List<Integer> tmp, int[] arr, int st) {
        list.add(new ArrayList<>(tmp)); // 리스트는 사본으로 추가 (상태 유지)
        for (int i = st; i < arr.length; i++) {
            tmp.add(arr[i]); // 값: 추가
            back(tmp, arr, (i + 1)); // 재귀
            tmp.remove(tmp.size() - 1); // 인덱스: 복구(제거)
        }
    }
}
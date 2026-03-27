class Solution {
    List<List<Integer>> list; // 반환용
    boolean[] visited; // 중복 방지

    public List<List<Integer>> permute(int[] nums) {
        list = new ArrayList<>();
        visited = new boolean[nums.length];
        perm(nums, new ArrayList<>());
        return list;
    }

    private void perm(int[] arr, List<Integer> tmp) {
        // tmp 크기 = 고른 원소 개수
        if (tmp.size() == arr.length) {
            list.add(new ArrayList<>(tmp)); // tmp 사본을 저장
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                tmp.add(arr[i]);
                perm(arr, tmp); // 재귀
                tmp.remove(tmp.size() - 1);
                visited[i] = false;
            }
        }
    }
}
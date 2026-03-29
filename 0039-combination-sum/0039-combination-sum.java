class Solution {
    // * 이 코드 말고도 for문 풀이(정석)도 가능 :
    // * idx 종료 조건 대신 i부터 시작하는 for문
    // * 재귀 호출은 comb(i, ...);만 작성
    // * for문 자체가 comb(i + 1, ...); 역할
    // * 재귀 시 합 sum에도 현재 원소 더해준다
    List<List<Integer>> l;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // 합 = target 중복 조합 (개수 제한 X)
        l = new ArrayList<>();
        comb(candidates, 0, 0, target, new ArrayList<>());
        return l;
    }

    private void comb(int[] nums, int idx, int sum, int goal, List<Integer> tmp) {
        // 달성 조건
        if (sum == goal) {
            l.add(new ArrayList<>(tmp));
            return;
        }
        // 종료 조건
        if (idx == nums.length || sum > goal) {
            return;
        }

        tmp.add(nums[idx]);
        comb(nums, idx, sum + nums[idx], goal, tmp); // 중복 (선택O)
        tmp.remove(tmp.size() - 1);
        comb(nums, idx + 1, sum, goal, tmp); // 다음 (선택X)
    }
}
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int diff; // 최소 차이 값
    TreeNode visited; // 이전 노드

    public int getMinimumDifference(TreeNode root) {
        // LMR 순으로 정렬됨: 인접 값끼리 차 비교
        diff = Integer.MAX_VALUE;
        visited = null;
        find(root); // 재귀로 탐색
        return diff;
    }

    private void find(TreeNode curr) {
        // 탐색할 노드 없으면 재귀 종료
        if (curr == null) {
            return;
        }

        find(curr.left); // L 재귀
        if (visited != null) {
            diff = Math.min(diff, curr.val - visited.val);
        }
        visited = curr; // M
        find(curr.right); // R 재귀
    }
}
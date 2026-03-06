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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        // 조건 충족한 root ~ leaf 경로 없음: F
        if (root == null) {
            return false;
        }

        // leaf 도달: 남은 합 = 현재 값 T/F
        if (root.left == null && root.right == null) {
            return root.val == targetSum;
        }

        // 좌우 재귀 (하나라도 T면 T) => 백트래킹에도 응용 가능
        return hasPathSum(root.left, (targetSum - root.val)) || hasPathSum(root.right, (targetSum - root.val));
    }
}
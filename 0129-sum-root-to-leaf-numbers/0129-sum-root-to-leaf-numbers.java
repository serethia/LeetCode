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
    public int sumNumbers(TreeNode root) {
        return sumUp(root, 0);
    }

    private int sumUp(TreeNode curr, int tot) {
        if (curr == null) {
            return 0;
        }

        tot = ((tot * 10) + curr.val);
        // leaf 도달: 총합 반환
        if (curr.left == null && curr.right == null) {
            return tot;
        }
        // 총합 구하기: 좌우의 합을 재귀로 합침
        return sumUp(curr.left, tot) + sumUp(curr.right, tot);
    }
}
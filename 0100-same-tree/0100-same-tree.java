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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true; // 둘 다 null
        } else if (p == null || q == null) {
            return false; // 한 쪽만 null
        } else if (p.val != q.val) {
            return false; // 다른 값
        }

        // 좌우 재귀 결과 비교
        return (isSameTree(p.left, q.left) && isSameTree(p.right, q.right));
    }
}
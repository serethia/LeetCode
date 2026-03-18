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
    // boolean 전역 변수 사용 시 불필요한 재귀 호출
    public boolean isValidBST(TreeNode root) {
        // L < M < R (노드 X, 서브 트리 O)
        return find(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean find(TreeNode curr, long st, long ed) {
        if (curr == null) {
            return true;
        }

        if (curr.val <= st || curr.val >= ed) {
            return false;
        }

        return (find(curr.left, st, curr.val) && find(curr.right, curr.val, ed));
    }
}
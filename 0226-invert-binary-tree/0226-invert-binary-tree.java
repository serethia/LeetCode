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
    public TreeNode invertTree(TreeNode root) {
        // 큐 활용한 BFS로도 가능
        if (root == null) {
            return null;
        }

        // 좌우 swap
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        // 재귀 (swap과 순서 바꿔도 무방)
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
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
    // MLR 순, right 연결, O(1) 공간: 포인터 + DFS
    public void flatten(TreeNode root) {
        // 왼쪽 트리의 제일 오른쪽 자식이 오른쪽 트리와 연결
        TreeNode curr = root;
        while (curr != null) {
            // [1] 왼쪽 자식이 있다면 왼쪽 트리로
            if (curr.left != null) {
                TreeNode ed = curr.left;
                // [2] 맨 오른쪽 자식 ed 탐색
                while (ed.right != null) {
                    ed = ed.right;
                }
                // [3] curr의 왼쪽, 오른쪽 처리
                ed.right = curr.right;
                curr.right = curr.left;
                curr.left = null;
            }
            curr = curr.right; // null 자동 처리
        }
    }
}
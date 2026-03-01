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
    public boolean isSymmetric(TreeNode root) {
        // 재귀적 & 반복적 풀이
        return compare(root.left, root.right);
    }

    // 좌우대칭 비교할 함수 따로 필요
    private boolean compare(TreeNode a, TreeNode b) {
        if (a == null && b == null) {
            return true;
        } else if (a == null || b == null) {
            return false;
        } else if (a.val != b.val) {
            return false;
        }
        // 바깥쪽끼리 & 안쪽끼리 비교
        return compare(a.left, b.right) && compare(b.left, a.right);
    }
}
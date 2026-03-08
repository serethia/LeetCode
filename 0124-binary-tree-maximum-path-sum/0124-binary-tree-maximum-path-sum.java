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
    int sum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        find(root); // 반환된 int 값 버림
        return sum;
    }

    private int find(TreeNode curr) {
        if (curr == null) {
            return 0; // 경로 없음
        }

        int leftSum = Math.max(0, find(curr.left)); // 왼쪽 트리 재귀 합 (음수 제거)
        int rightSum = Math.max(0, find(curr.right)); // 오른쪽 트리 재귀 합 (음수 제거)
        sum = Math.max(sum, (curr.val + leftSum + rightSum)); // 현재 노드, 좌 트리, 우 트리 총합과의 최댓값 비교

        return (curr.val + Math.max(leftSum, rightSum)); // 좌 or 우 선택
    }
}
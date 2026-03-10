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
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        TreeNode lft = root;
        int h = 0; // 왼쪽 깊이
        // 맨 왼쪽 가지로 h 계산
        while (lft != null) {
            lft = lft.left;
            h++;
        }

        TreeNode rgt = root;
        int d = 0; // 오른쪽 깊이
        // 맨 오른쪽 가지로 d 계산
        while (rgt != null) {
            rgt = rgt.right;
            d++;
        }

        if (h == d) {
            // perfect binary tree: 2^h 활용
            return ((1 << h) - 1); // 비트 연산자
        } else {
            // 시간복잡도 O(n) 미만: 단순 (1 + L재귀 + R재귀)는 O(n)이므로 최소한의 서브 트리만 탐색
            return (1 + countNodes(root.left) + countNodes(root.right));
        }
    }
}
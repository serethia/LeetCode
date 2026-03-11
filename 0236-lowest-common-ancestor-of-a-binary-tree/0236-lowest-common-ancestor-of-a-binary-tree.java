/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 노드 없음
        if (root == null) {
            return null;
        }

        // 둘 중 하나에 root 있으면 root가 LCA
        if (root == p || root == q) {
            return root;
        }

        // 왼쪽 서브 트리, 오른쪽 서브 트리 재귀로 탐색
        TreeNode lft = lowestCommonAncestor(root.left, p, q);
        TreeNode rgt = lowestCommonAncestor(root.right, p, q);
        // p, q가 다른 트리면 맨 처음 부모 노드가 LCA
        if (lft != null && rgt != null) {
            return root;
        }

        // p, q가 같은 트리면 나온 쪽을 부모로 전달
        // p, q가 서로 [조상-자손]인 경우도 고려
        if (lft != null) {
            return lft;
        } else {
            return rgt;
        }
    }
}
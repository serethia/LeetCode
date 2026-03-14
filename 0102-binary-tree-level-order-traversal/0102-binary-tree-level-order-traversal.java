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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> l = new ArrayList<>();
        if (root == null) {
            return l;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        // 깊이 별 좌->우 노드 val
        while (!q.isEmpty()) {
            int n = q.size();
            List<Integer> tmp = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                TreeNode curr = q.poll();
                tmp.add(curr.val);
                if (curr.left != null) {
                    q.offer(curr.left);
                }
                if (curr.right != null) {
                    q.offer(curr.right);
                }
            }
            l.add(tmp);
        }
        return l;
    }
}
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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> l = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            double sum = 0; // 현재 깊이 노드 값 총합
            int n = q.size(); // 현재 깊이 노드 수
            for (int i = 0; i < n; i++) {
                // 현재 깊이
                TreeNode curr = q.poll();
                sum += curr.val;

                // 다음 깊이
                if (curr.left != null) {
                    q.offer(curr.left);
                }
                if (curr.right != null) {
                    q.offer(curr.right);
                }
            }
            // 평균값 추가 (double ÷ int = double)
            l.add(sum / n);
        }
        return l;
    }
}
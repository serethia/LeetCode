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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> l = new ArrayList<>();
        if (root == null) {
            return l;
        }

        // BFS는 그대로, 값 넣는 순서만 지그재그
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        int d = 1; // 현재 깊이
        while (!q.isEmpty()) {
            int n = q.size();
            List<Integer> tmp = new LinkedList<>(); // 연결리스트(덱): addFirst, addLast
            for (int i = 0; i < n; i++) {
                TreeNode curr = q.poll();
                // 현재 깊이 탐색
                if (d % 2 == 1) {
                    // 홀수: 좌->우
                    tmp.addLast(curr.val);
                } else {
                    // 짝수: 우->좌
                    tmp.addFirst(curr.val);
                }

                // 다음 깊이 탐색
                if (curr.left != null) {
                    q.offer(curr.left);
                }
                if (curr.right != null) {
                    q.offer(curr.right);
                }
            }
            l.add(tmp);
            d++; // 다음 깊이로
        }
        return l;
    }
}
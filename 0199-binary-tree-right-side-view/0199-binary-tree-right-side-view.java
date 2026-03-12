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
    public List<Integer> rightSideView(TreeNode root) {
        // 값 반환용 연결리스트
        List<Integer> l = new LinkedList<>();
        if (root == null) {
            return l;
        }

        // BFS용 큐 (덱으로 생성, FIFO)
        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root); // 시작점 넣어 두기
        while (!q.isEmpty()) {
            int n = q.size(); // 현재 깊이 노드 수
            for (int i = 0; i < n; i++) {
                // 현재 노드: q에서 제거
                TreeNode curr = q.poll();
                // 맨 오른쪽 노드: 값을 l에 추가
                if (i == n - 1) {
                    l.add(curr.val);
                }
                // 자식 존재 (왼->오): q에 추가
                if (curr.left != null) {
                    q.offer(curr.left);
                }
                if (curr.right != null) {
                    q.offer(curr.right);
                }
            }
        }
        return l;
    }
}
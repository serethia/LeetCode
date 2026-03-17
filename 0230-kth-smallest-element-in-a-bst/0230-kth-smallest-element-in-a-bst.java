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
    int kth = 0; // k번째
    int v = 0; // k번째 작은 값

    public int kthSmallest(TreeNode root, int k) {
        // LMR(inorder)로 오름차순 (스택으로 풀어도 무방)
        find(root, k);
        return v;
    }

    private void find(TreeNode curr, int k) {
        // 노드 없음: 재귀 종료
        if (curr == null) {
            return;
        }

        find(curr.left, k); // L
        if (++kth == k) { // M
            // k번째 값: 재귀 종료 & 값 저장
            v = curr.val;
            return;
        }
        find(curr.right, k); // R
    }
}

// [follow up] 삽입/제거 변경이 자주 발생할 때 심화 알고리즘: 
// 각 노드에 서브 트리 크기를 새로 저장해 삽입/제거 때 활용하는 《order statistic tree》
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
    int parent; // 부모 노드 idx (인스턴스)

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // preorder = MLR (부모 노드 판단)
        // inorder = LMR (좌우 트리 구분)
        return divide(preorder, inorder, 0, preorder.length);
    }

    // MLR 노드리스트, LMR 노드리스트, 시작idx, 끝idx
    private TreeNode divide(int[] pre, int[] in, int subSt, int subEd) {
        // 자식 노드 없으면 서브 트리 없음: null
        if (subSt >= subEd) {
            return null;
        }

        TreeNode curr = new TreeNode(pre[parent]); // 부모 노드 갱신
        for (int i = subSt; i < subEd; i++) {
            if (in[i] == pre[parent]) {
                // 부모 노드 찾으면 그 다음 부모로
                parent++;
                // 재귀 활용해 좌우 트리 분할
                curr.left = divide(pre, in, subSt, i);
                curr.right = divide(pre, in, (i + 1), subEd);
                // 서브 트리 나눴으니 루프 중지
                break;
            }
        }
        return curr; // 부모 노드부터 반환
    }
}
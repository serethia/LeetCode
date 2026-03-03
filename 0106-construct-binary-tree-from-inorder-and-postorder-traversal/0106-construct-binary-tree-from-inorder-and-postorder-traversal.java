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
    int parent; // 부모 노드 idx

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // inorder: LMR, postorder: LRM
        parent = postorder.length - 1;
        return divide(inorder, postorder, 0, inorder.length);
    }

    private TreeNode divide(int[] in, int[] post, int st, int ed) {
        if (st >= ed) {
            return null;
        }

        TreeNode curr = new TreeNode(post[parent]);
        for (int i = st; i < ed; i++) {
            if (in[i] == curr.val) {
                parent--;
                // postorder (LRM) 역순 진행: 오른쪽 먼저
                curr.right = divide(in, post, (i + 1), ed);
                curr.left = divide(in, post, st, i);
                break;
            }
        }
        return curr;
    }
}
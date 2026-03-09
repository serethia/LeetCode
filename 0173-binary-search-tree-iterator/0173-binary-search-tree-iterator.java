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
class BSTIterator {
    // O(1) 시간, O(h) 공간 (h: 트리 높이)
    Stack<TreeNode> stack;

    // root 기준으로 스택 초기화
    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        // M 노드, L 트리 모두 push
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }

    // LMR 순 다음 노드 값
    public int next() {
        // 이 문제는 isEmpty 검사 필요X
        TreeNode nxt = stack.pop();
        if (nxt.right != null) {
            // R이 M 노드로, L 트리까지 push
            TreeNode curr = nxt.right;
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
        }
        // int 값으로 반환
        return nxt.val;
    }

    // 다음 노드 존재 여부
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
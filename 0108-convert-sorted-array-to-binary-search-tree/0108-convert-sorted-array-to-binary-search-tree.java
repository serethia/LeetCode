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
    public TreeNode sortedArrayToBST(int[] nums) {
        return divide(nums, 0, nums.length - 1);
    }

    private TreeNode divide(int[] arr, int st, int ed) {
        if (st > ed) {
            return null; // 만들 노드 없으면 null
        }

        int mid = ((st + ed) / 2); // 인덱스 중간값
        TreeNode root = new TreeNode(arr[mid]); // 중간값으로 기준점 루트 생성
        root.left = divide(arr, st, mid - 1);
        root.right = divide(arr, mid + 1, ed);
        return root;
    }
}
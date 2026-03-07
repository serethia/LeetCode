1/**
2 * Definition for a binary tree node.
3 * public class TreeNode {
4 *     int val;
5 *     TreeNode left;
6 *     TreeNode right;
7 *     TreeNode() {}
8 *     TreeNode(int val) { this.val = val; }
9 *     TreeNode(int val, TreeNode left, TreeNode right) {
10 *         this.val = val;
11 *         this.left = left;
12 *         this.right = right;
13 *     }
14 * }
15 */
16class Solution {
17    public int sumNumbers(TreeNode root) {
18        return sumUp(root, 0);
19    }
20
21    private int sumUp(TreeNode curr, int tot) {
22        if (curr == null) {
23            return 0;
24        }
25
26        tot = ((tot * 10) + curr.val);
27        // leaf 도달: 총합 반환
28        if (curr.left == null && curr.right == null) {
29            return tot;
30        }
31        // 총합 구하기: 좌우의 합을 재귀로 합침
32        return sumUp(curr.left, tot) + sumUp(curr.right, tot);
33    }
34}
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
    private void inOrder(TreeNode root, int[] res, int k) {
        if (root == null) return;

        inOrder(root.left, res, k);

        res[0] += 1;
        if (res[0] == k) {res[1] = root.val; return;}

        inOrder(root.right, res, k);
    }

    public int kthSmallest(TreeNode root, int k) {
        int[] res = new int[2];
        
        res[0] = 0;

        inOrder(root, res, k);

        return res[1];
    }
}

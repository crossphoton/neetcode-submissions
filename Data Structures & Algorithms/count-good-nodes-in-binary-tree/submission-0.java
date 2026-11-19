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
    private int dfs(TreeNode root, int greatest) {
        if (root == null) return 0;

        int maxValue = Math.max(greatest, root.val);
        int result = dfs(root.left, maxValue) + dfs(root.right, maxValue);

        return ((greatest > root.val) ? 0: 1) + result;
    }
    public int goodNodes(TreeNode root) {
        return dfs(root, root.val);
    }
}

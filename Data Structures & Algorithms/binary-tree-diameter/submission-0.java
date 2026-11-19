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
    class SearchResult {
        int depth;
        int diameter;

        SearchResult(int dep, int dia) {
            depth = dep;
            diameter = dia;
        }
    }

    private SearchResult findDiameter(TreeNode root) {
        if (root == null) return new SearchResult(0, 0);
        SearchResult left = findDiameter(root.left);
        SearchResult right = findDiameter(root.right);

        int currentDepth = 1 + Math.max(left.depth, right.depth);

        int currentDiameter = left.depth + right.depth;
        
        int resultDiameter = Math.max(Math.max(currentDiameter, left.diameter), right.diameter);

        if (currentDepth == 20 || currentDepth == 18) {
            System.out.println(root.val + "  " + resultDiameter);
        }

        return new SearchResult(currentDepth, resultDiameter);
    }

    public int diameterOfBinaryTree(TreeNode root) {
        return findDiameter(root).diameter;
    }
}
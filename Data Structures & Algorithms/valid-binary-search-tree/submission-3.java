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
    class Validity {
        boolean isValid;
        int max, min;

        public Validity(boolean a, int b, int c) {
            isValid = a;
            max = b;
            min = c;
        }
    }

    private Validity dfs(TreeNode root) {
        if (root == null) {
            return new Validity(true, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }

        Validity left = dfs(root.left);
        Validity right = dfs(root.right);

        if (!left.isValid || !right.isValid) {
            return new Validity(false, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }

        if (left.max >= root.val) {
            return new Validity(false, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }

        if (right.min <= root.val) {
            return new Validity(false, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }

        return new Validity(
            true,
            Math.max(root.val, right.max),
            Math.min(root.val, left.min)
        );
    }


    public boolean isValidBST(TreeNode root) {
        return dfs(root).isValid;      
    }
}
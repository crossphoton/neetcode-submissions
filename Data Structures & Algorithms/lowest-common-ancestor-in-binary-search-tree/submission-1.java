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
    private boolean[] test(TreeNode root, TreeNode p, TreeNode q, TreeNode result) {
        if (root == null) return new boolean[]{false, false};

        boolean[] left = test(root.left, p, q, result);
        boolean[] right = test(root.right, p, q, result);

        if ((left[0] && left[1]) ||
            (right[0]&& right[1])) return new boolean[]{true, true};

        boolean pFound = left[0] | right[0] | (root.val == p.val);
        boolean qFound = left[1] | right[1] | (root.val == q.val);

        if (pFound && qFound) {
            result.val = root.val;
            result.left = root.left;
            result.right = root.right;
        }

        return new boolean[]{pFound, qFound};
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode cur = root;

        while (cur != null) {
            if (p.val > cur.val && q.val > cur.val) {
                cur = cur.right;
            } else if (p.val < cur.val && q.val < cur.val) {
                cur = cur.left;
            } else {
                return cur;
            }
        }
        return null;
    }
}

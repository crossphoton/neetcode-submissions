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
    private void inOrder(TreeNode root, List<Integer> res) {
        if (root == null) return;

        inOrder(root.left, res);
        res.add(root.val);
        inOrder(root.right, res);
    }

    private boolean isSorted(List<Integer> array) {
        for (int i=1; i < array.size(); i++) {
            if (array.get(i) <= array.get(i-1)) {
                return false;
            }
        }

        return true;
    }


    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;

        List<Integer> res = new ArrayList<>();

        inOrder(root, res);

        return isSorted(res);
    }
}
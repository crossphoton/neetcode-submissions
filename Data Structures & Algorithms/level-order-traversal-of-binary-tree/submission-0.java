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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();

        q.offer(root);

        while (!q.isEmpty()) {
            int n = q.size();

            List<Integer> current = new ArrayList<>();

            while (n-- > 0) {
                TreeNode currentNode = q.poll();
                if (currentNode == null) continue;

                current.add(currentNode.val);

                q.offer(currentNode.left);
                q.offer(currentNode.right);
            }

            if (current.size() > 0)
            result.add(current);
        }

        return result;
    }
}

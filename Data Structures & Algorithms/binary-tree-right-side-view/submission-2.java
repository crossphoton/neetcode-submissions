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
    public List<Integer> rightSideView(TreeNode root) {
        List<List<Integer>> levelOrder = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
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
            levelOrder.add(current);
        }

        for (int i=0; i<levelOrder.size(); i++) {
            result.add(levelOrder.get(i).get(levelOrder.get(i).size() - 1));
        }

        return result;
    }
}

/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node input) {
        if (input == null) return null;

        Set<Integer> vis = new HashSet<>();
        Queue<Node> q = new LinkedList<>();
        Map<Integer, Node> m = new HashMap<>();

        q.add(input);
        vis.add(input.val);

        while (!q.isEmpty()) {
            Node node = q.poll();
            System.out.print(node.val + ", ");

            Node copyNode = m.computeIfAbsent(node.val, val -> new Node(val));
            m.put(node.val, copyNode);

            for (Node n: node.neighbors) {
                Node copyNeighbour = m.computeIfAbsent(n.val, val -> new Node(val));
                copyNode.neighbors.add(copyNeighbour);
                if (!vis.contains(n.val)) q.add(n);
                vis.add(n.val);
            }
        }

        return m.get(input.val);
    }
}
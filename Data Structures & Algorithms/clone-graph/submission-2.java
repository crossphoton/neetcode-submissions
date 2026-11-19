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
        m.put(input.val, new Node(input.val));

        while (!q.isEmpty()) {
            Node node = q.poll();

            for (Node n: node.neighbors) {
                if (!m.containsKey(n.val)) {
                    m.put(n.val, new Node(n.val));
                    q.add(n);
                }

                m.get(node.val).neighbors.add(m.get(n.val));
            }
        }

        return m.get(input.val);
    }
}
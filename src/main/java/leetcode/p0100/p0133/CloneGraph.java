package leetcode.p0100.p0133;

import java.util.*;

public class CloneGraph {
    final private Map<Integer, Node> cache = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) return null;
        if (cache.containsKey(node.val)) {
            return cache.get(node.val);
        }

        Node clone = new Node(node.val);
        cache.put(node.val, clone);
        for (Node neighbor : node.neighbors) {
            clone.neighbors.add(cloneGraph(neighbor));
        }

        return clone;
    }

    private static class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
}

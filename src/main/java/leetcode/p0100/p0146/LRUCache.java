package leetcode.p0100.p0146;

import java.util.*;

public class LRUCache {
    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        var node = map.get(key);
        list.remove(node);
        list.add(node);
        return node.val;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            var node = map.get(key);
            node.val = value;
            list.remove(node);
            list.add(node);
        } else {
            if (map.size() == capacity) {
                var first = list.removeFirst();
                map.remove(first.key);
            }
            Node node = new Node(key, value);
            map.put(key, node);
            list.add(node);
        }
    }

    private final int capacity;
    private final Map<Integer, Node> map = new HashMap<>();
    private final LinkedList<Node> list = new LinkedList<>();

    private static class Node {
        int key;
        int val;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
}

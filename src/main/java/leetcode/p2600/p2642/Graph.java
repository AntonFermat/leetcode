package leetcode.p2600.p2642;

import java.util.*;

public class Graph {
    private final Map<Integer, HashMap<Integer, Integer>> map;
    
    public Graph(int n, int[][] edges) {
        this.map = new HashMap<>();
        for (var e : edges) {
            map.computeIfAbsent(e[0], o -> new HashMap<>()).put(e[1], e[2]);
        }
    }

    public void addEdge(int[] edge) {
        map.computeIfAbsent(edge[0], o -> new HashMap<>()).put(edge[1], edge[2]);
    }

    public int shortestPath(int node1, int node2) {
        var pq = new PriorityQueue<int[]>(Comparator.comparingInt(i -> i[0]));
        pq.add(new int[]{0, node1});
        var visited = new HashSet<Integer>();

        while (!pq.isEmpty()) {
            var poll = pq.poll();
            int w = poll[0];
            int cur = poll[1];
            if (cur == node2) return w;

            if (visited.contains(cur)) continue;
            visited.add(cur);

            if (map.containsKey(cur)) {
                for (var nextNode : map.get(cur).entrySet()) {
                    int next = nextNode.getKey();
                    int wnext = nextNode.getValue();
                    pq.add(new int[]{wnext + w, next});
                }
            }
        }
        return -1;
    }
}

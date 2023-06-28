package leetcode.p1500.p1514;

import java.util.*;

public class PathWithMaximumProbability {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        var map = new HashMap<Integer, HashMap<Integer, Double>>();
        for (int i = 0; i < edges.length; i++) {
            var e = edges[i];
            map.computeIfAbsent(e[0], o -> new HashMap<>()).put(e[1], succProb[i]);
            map.computeIfAbsent(e[1], o -> new HashMap<>()).put(e[0], succProb[i]);
        }

        var pq = new PriorityQueue<Pair>((p1, p2)
                -> Double.compare(p2.value(), p1.value()));

        pq.add(new Pair(start, 1.0));
        var visited = new HashSet<Integer>();
        while (!pq.isEmpty()) {
            var node = pq.poll();
            int cur = node.key();
            double prob = node.value();

            if (cur == end) return prob;

            if (visited.contains(cur)) continue;
            visited.add(cur);

            if (map.containsKey(cur)) {
                for (var nextNode : map.get(cur).entrySet()) {
                    int next = nextNode.getKey();
                    double nextProb = nextNode.getValue();
                    pq.add(new Pair(next, prob * nextProb));
                }
            }
        }
        return 0;
    }

    record Pair(int key, double value) {
    }
}

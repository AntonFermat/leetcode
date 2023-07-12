package leetcode.p0800.p0802;

import java.util.*;

public class FindEventualSafeStates {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int len = graph.length;
        HashSet<Integer>[] map1 = new HashSet[len];
        HashSet<Integer>[] map2 = new HashSet[len];
        var q = new LinkedList<Integer>();
        for (int i = 0; i < len; i++) {
            if (graph[i].length == 0) q.add(i);
            else {
                if (map1[i] == null) map1[i] = new HashSet<>();
                for (var g : graph[i]) {
                    map1[i].add(g);
                }
                for (var g : graph[i]) {
                    if (map2[g] == null) map2[g] = new HashSet<>();
                    map2[g].add(i);
                }
            }
        }

        var safe = new TreeSet<Integer>();
        while (!q.isEmpty()) {
            var cur = q.pop();
            safe.add(cur);
            if (map2[cur] == null) continue;
            for (var next : map2[cur]) {
                map1[next].remove(cur);
                if (map1[next].isEmpty())
                    q.add(next);
            }
        }
        return new ArrayList<>(safe);
    }
}

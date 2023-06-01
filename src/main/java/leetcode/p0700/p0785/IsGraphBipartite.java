package leetcode.p0700.p0785;

import java.util.*;

public class IsGraphBipartite {
    public boolean isBipartite(int[][] graph) {
        var map = new HashMap<Integer, Set<Integer>>();
        for (int i = 0; i < graph.length; i++) {
            for (int j : graph[i]) {
                map.computeIfAbsent(i, o -> new HashSet<>()).add(j);
                map.computeIfAbsent(j, o -> new HashSet<>()).add(i);
            }
        }

        var gmap = new HashMap<Integer, Integer>();
        for (int i : map.keySet()) {
            if (gmap.containsKey(i)) continue;

            gmap.put(i, 1);
            var q = new LinkedList<Integer>();
            q.add(i);
            while (!q.isEmpty()) {
                var cur = q.pop();
                Integer group = gmap.get(cur);
                if (map.containsKey(cur)) {
                    for (int next : map.get(cur)) {
                        if (group.equals(gmap.get(next))) return false;
                        if (!gmap.containsKey(next)) {
                            gmap.put(next, group == 1 ? 2 : 1);
                            q.add(next);
                        }
                    }
                }
            }
        }
        return true;
    }
}

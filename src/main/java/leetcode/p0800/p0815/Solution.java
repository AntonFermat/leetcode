package leetcode.p0800.p0815;

import java.util.*;

public class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) return 0;
        var sroute = new HashSet<Integer>();
        var troute = new HashSet<Integer>();
        //stop -> route
        var rmap = new HashMap<Integer, Set<Integer>>();
        //route -> route
        var map = new HashMap<Integer, Set<Integer>>();
        for (int i = 0; i < routes.length; i++) {
            for (int j = 0; j < routes[i].length; j++) {
                int stop = routes[i][j];
                if (stop == source) sroute.add(i);
                if (stop == target) troute.add(i);
                if (rmap.containsKey(stop)) {
                    map.computeIfAbsent(i, o -> new HashSet<>()).addAll(rmap.get(stop));
                }
                rmap.computeIfAbsent(stop, o -> new HashSet<>()).add(i);
            }
        }

        for (int r : new HashSet<>(map.keySet())) {
            for (var x : map.get(r)) {
                map.computeIfAbsent(x, o -> new HashSet<>()).add(r);
            }
        }

        var q = new LinkedList<>(sroute);
        var v = new HashSet<>(sroute);
        int res = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            res++;
            while (size-- > 0) {
                int cur = q.poll();
                if (troute.contains(cur)) return res;

                if (map.containsKey(cur)) {
                    for (int next : map.get(cur)) {
                        if (v.contains(next)) continue;
                        q.add(next);
                        v.add(next);
                    }
                }
            }
        }
        return -1;
    }
}

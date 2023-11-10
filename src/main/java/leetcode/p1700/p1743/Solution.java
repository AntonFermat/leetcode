package leetcode.p1700.p1743;

import java.util.*;

public class Solution {
    public int[] restoreArray(int[][] adjacentPairs) {
        int n = adjacentPairs.length + 1;
        var res = new int[n];
        var map = new HashMap<Integer, Set<Integer>>();
        var set = new HashSet<Integer>();
        for (int[] p : adjacentPairs) {
            if (!set.remove(p[0])) set.add(p[1]);
            if (!set.remove(p[1])) set.add(p[0]);
            map.computeIfAbsent(p[0], o -> new HashSet<>()).add(p[1]);
            map.computeIfAbsent(p[1], o -> new HashSet<>()).add(p[0]);
        }
        int start = set.iterator().next();
        var q = new LinkedList<>(List.of(start));
        var v = new HashSet<>(List.of(start));
        int index = 0;
        while (!q.isEmpty()) {
            int cur = q.poll();
            res[index++] = cur;
            for (int next : map.get(cur)) {
                if (!v.contains(next)) {
                    q.add(next);
                    v.add(next);
                }
            }
        }
        return res;
    }
}

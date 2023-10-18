package leetcode.p2000.p2050;

import java.util.*;

public class Solution {
    public int minimumTime(int n, int[][] relations, int[] time) {
        var degree = new int[n + 1];
        var map = new HashMap<Integer, Set<Integer>>();
        for (int[] r : relations) {
            degree[r[1]]++;
            map.computeIfAbsent(r[0], o -> new HashSet<>()).add(r[1]);
        }
        var dist = new int[n + 1];
        var q = new LinkedList<int[]>();
        for (int i = 1; i < n + 1; i++) {
            if (degree[i] == 0) {
                q.add(new int[]{i, time[i - 1]});
            }
            dist[i] = time[i - 1];
        }

        while (!q.isEmpty()) {
            var poll = q.poll();
            int cur = poll[0];
            int d = poll[1];
            if (map.containsKey(cur)) {
                for (int next : map.get(cur)) {
                    degree[next]--;
                    dist[next] = Math.max(dist[next], d + time[next - 1]);
                    if (degree[next] == 0) {
                        q.add(new int[]{next, dist[next]});
                    }
                }
            }
        }
        int res = 0;
        for (int d : dist) res = Math.max(res, d);
        return res;
    }
}

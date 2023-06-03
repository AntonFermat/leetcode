package leetcode.p2100.p2101;

import java.util.*;

public class DetonateTheMaximumBombs {

    public int maximumDetonation(int[][] bombs) {
        int len = bombs.length;
        var map = new HashMap<Integer, Set<Integer>>();
        for (int i = 0; i < len - 1; i++) {
            var b1 = bombs[i];
            for (int j = i + 1; j < len; j++) {
                var b2 = bombs[j];
                long rr = (long) (b1[0] - b2[0]) * (b1[0] - b2[0]) + (long) (b1[1] - b2[1]) * (b1[1] - b2[1]);
                if (rr <= (long) b1[2] * b1[2]) map.computeIfAbsent(i, o -> new HashSet<>()).add(j);
                if (rr <= (long) b2[2] * b2[2]) map.computeIfAbsent(j, o -> new HashSet<>()).add(i);
            }
        }
        int res = 1;
        for (int i = 0; i < len; i++) {
            if (map.containsKey(i)) {
                var q = new LinkedList<Integer>();
                q.add(i);
                var visited = new HashSet<Integer>();
                visited.add(i);
                while (!q.isEmpty()) {
                    int cur = q.poll();
                    if (map.containsKey(cur)) {
                        for (var next : map.get(cur)) {
                            if (visited.contains(next)) continue;
                            q.add(next);
                            visited.add(next);
                        }

                    }
                }
                res = Math.max(res, visited.size());
            }
        }
        return res;
    }
}

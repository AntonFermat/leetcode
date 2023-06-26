package leetcode.p1500.p1575;

import java.util.*;

public class CountAllPossibleRoutes {
    public int countRoutes(int[] locations, int start, int finish, int fuel) {
        int len = locations.length;

        for (int i = 0; i < len; i++) {
            int a = locations[i];
            for (int j = i + 1; j < len; j++) {
                int b = locations[j];
                int dist = Math.abs(a - b);
                map.computeIfAbsent(i, o -> new TreeMap<>())
                        .computeIfAbsent(dist, o -> new TreeSet<>()).add(j);
                map.computeIfAbsent(j, o -> new TreeMap<>())
                        .computeIfAbsent(dist, o -> new TreeSet<>()).add(i);
            }
        }
        var memo = new int[len][len][fuel + 1];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) Arrays.fill(memo[i][j], -1);
        }
        return (start == finish ? 1 : 0) + helper(start, finish, fuel, memo);
    }

    private int helper(int start, int finish, int fuel, int[][][] memo) {
        long res = 0;

        if (fuel < 0) return 0;

        if (memo[start][finish][fuel] != -1) return memo[start][finish][fuel];

        var avail = map.get(start).subMap(0, true, fuel, true);
        for (var a : avail.entrySet()) {
            int dist = a.getKey();
            for (int next : a.getValue()) {
                if (next == finish) res = (res + 1);
                res = (res + helper(next, finish, fuel - dist, memo)) % 1_000_000_007;
            }
        }
        return memo[start][finish][fuel] = (int) res;
    }

    private final TreeMap<Integer, TreeMap<Integer, TreeSet<Integer>>> map = new TreeMap<>();
}

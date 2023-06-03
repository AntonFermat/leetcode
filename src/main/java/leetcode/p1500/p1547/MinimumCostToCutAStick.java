package leetcode.p1500.p1547;

import java.util.*;

public class MinimumCostToCutAStick {
    TreeSet<Integer> cc = new TreeSet<>();
    Map<Pair<Integer, Integer>, Integer> memo = new HashMap<>();

    public int minCost(int n, int[] cuts) {
        for (int c : cuts) cc.add(c);
        return helper(0, n);
    }

    private int helper(int l, int r) {
        if (l >= r) return 0;
        int res = r - l;
        var set = cc.subSet(l + 1, r);
        if (set.isEmpty()) return 0;
        var p = new Pair<>(l, r);
        if (memo.containsKey(p)) return memo.get(p);
        int cur = -1;
        for (var m : set) {
            if (cur == -1) cur = helper(l, m) + helper(m, r);
            else cur = Math.min(cur, helper(l, m) + helper(m, r));
        }
        memo.put(p, res + cur);
        return res + cur;
    }

    private record Pair<E, P>(E key, P value) {
    }
}

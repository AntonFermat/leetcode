package leetcode.p2200.p2225;

import java.util.*;

public class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        var map = new TreeMap<Integer, Integer>();
        for (int[] m : matches) {
            map.put(m[0], map.getOrDefault(m[0], 0));
            map.put(m[1], map.getOrDefault(m[1], 0) + 1);
        }
        List<List<Integer>> res = List.of(new ArrayList<>(), new ArrayList<>());
        for (var e : map.entrySet()) {
            if (e.getValue() == 0) res.get(0).add(e.getKey());
            else if (e.getValue() == 1) res.get(1).add(e.getKey());
        }
        return res;
    }
}

package leetcode.p2200.p2251;

import java.util.*;

public class Solution {
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        var start = new TreeMap<Integer, Integer>();
        var end = new TreeMap<Integer, Integer>();
        start.put(0, 0);
        end.put(0, 0);
        Arrays.sort(flowers, Comparator.comparingInt(f -> f[0]));
        for (var f : flowers) {
            int s = f[0];
            var se = start.floorEntry(s);
            start.put(s, se.getValue() + 1);
        }
        Arrays.sort(flowers, Comparator.comparingInt(f -> f[1]));
        for (var f : flowers) {
            int e = f[1] + 1;
            var ee = end.floorEntry(e);
            end.put(e, ee.getValue() + 1);
        }
        int len = people.length;
        var res = new int[len];
        for (int i = 0; i < len; i++) {
            int p = people[i];
            res[i] = start.floorEntry(p).getValue() - end.floorEntry(p).getValue();
        }
        return res;
    }
}
package leetcode.p0800.p0823;

import java.util.*;

public class Solution {
    public int numFactoredBinaryTrees(int[] arr) {
        int mod = 1_000_000_007;
        Arrays.sort(arr);
        var map = new HashMap<Long, Long>();
        for (long a : arr) {
            long cur = 1;
            var prev = map.keySet();
            for (long num1 : prev) {
                if (a % num1 != 0) continue;
                long num2 = a / num1;
                if (prev.contains(num2)) {
                    cur = (cur + map.get(num1) * map.get(num2)) % mod;
                }
            }
            map.put(a, cur);
        }
        long res = 0;
        for (long value : map.values()) res = (value + res) % mod;
        return (int) res;
    }
}

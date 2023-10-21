package leetcode.p1400.p1425;

import java.util.TreeMap;

public class Solution {
    public int constrainedSubsetSum(int[] nums, int k) {
        int len = nums.length;
        int res = Integer.MIN_VALUE;
        var map = new TreeMap<Integer, Integer>();
        var dp = new int[len];
        for (int i = 0; i < len; i++) {
            int num = nums[i];
            int max = map.isEmpty() ? 0 : map.lastKey();
            if (i >= k) {
                int rem = dp[i - k];
                int count = map.get(rem);
                if (count == 1) map.remove(rem);
                else map.put(rem, count - 1);
            }
            int cur = Math.max(num, num + max);
            map.put(cur, map.getOrDefault(cur, 0) + 1);
            dp[i] = cur;
            res = Math.max(res, cur);
        }
        return res;
    }
}

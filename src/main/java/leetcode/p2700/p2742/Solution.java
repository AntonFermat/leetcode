package leetcode.p2700.p2742;

import java.util.Arrays;

public class Solution {
    public int paintWalls(int[] cost, int[] time) {
        int len = cost.length;
        var dp = new int[len + 1];
        Arrays.fill(dp, 1_000_000_000);
        dp[0] = 0;
        for (int i = 0; i < len; i++) {
            for (int j = len; j >= 0; j--) {
                int t = Math.max(0, j - 1 - time[i]);
                dp[j] = Math.min(dp[j], cost[i] + dp[t]);
            }
        }
        return dp[len];
    }
}

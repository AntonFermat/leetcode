package leetcode.p0700.p0746;

public class Solution {
    public int minCostClimbingStairs(int[] cost) {
        var dp = new int[cost.length + 1];
        for (int i = 2; i <= cost.length; i++) dp[i] = Math.min(dp[i - 2] + cost[i - 2], dp[i - 1] + cost[i - 1]);
        return dp[cost.length];
    }
}

package leetcode.p1300.p1335;

import java.util.Arrays;

public class Solution {
    private int[] jd;
    private int[][] dp;

    public int minDifficulty(int[] jobDifficulty, int d) {
        if (jobDifficulty.length < d) return -1;
        jd = jobDifficulty;
        dp = new int[jd.length][d + 1];
        for (int i = 0; i < jd.length; i++) Arrays.fill(dp[i], -1);
        return helper(0, d);
    }

    private int helper(int index, int d) {
        int len = jd.length;
        int max = 0;
        if (dp[index][d] != -1) return dp[index][d];
        if (d == 1) {
            for (int i = index; i < len; i++) max = Math.max(max, jd[i]);
            return dp[index][d] = max;
        }
        int res = Integer.MAX_VALUE;
        for (int i = index; i <= len - d; i++) {
            max = Math.max(max, jd[i]);
            res = Math.min(res, max + helper(i + 1, d - 1));
        }
        return dp[index][d] = res;
    }
}

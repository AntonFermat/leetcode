package leetcode.p0600.p0629;

import java.util.Arrays;

public class Solution {
    public int kInversePairs(int n, int k) {
        var dp = new int[1001][1001];
        Arrays.stream(dp).forEach(arr -> Arrays.fill(arr, -1));
        return kInversePairs(n, k, dp);
    }

    public int kInversePairs(int n, int k, int[][] dp) {
        if (k == 0) return 1;
        if (dp[n][k] == -1) {
            dp[n][k] = 0;
            for (int i = 0; i <= Math.min(k, n - 1); i++) {
                dp[n][k] = (dp[n][k] + kInversePairs(n - 1, k - i, dp)) % 1_000_000_007;
            }
        }
        return dp[n][k];
    }
}

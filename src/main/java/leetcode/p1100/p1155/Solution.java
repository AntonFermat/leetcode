package leetcode.p1100.p1155;

public class Solution {
    private final int mod = 1_000_000_007;
    private Integer[][] dp;

    public int numRollsToTarget(int n, int k, int t) {
        if (n == 1) {
            if (t >= 1 && t <= k) return 1;
        }
        long res = 0;
        if (dp == null) dp = new Integer[n][t];
        for (int i = 1; i <= k; i++) {
            if (n - 1 < 0 || t - i <= 0) continue;
            if (dp[n - 1][t - i] == null) {
                dp[n - 1][t - i] = numRollsToTarget(n - 1, k, t - i);
            }
            res = (res + dp[n - 1][t - i]) % mod;
        }
        return (int) res;
    }
}
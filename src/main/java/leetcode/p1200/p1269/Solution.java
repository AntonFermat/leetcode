package leetcode.p1200.p1269;

public class Solution {
    public int numWays(int steps, int arrLen) {
        int mod = 1_000_000_007;
        arrLen = Math.min(steps, arrLen);
        var dp = new int[arrLen];
        dp[0] = 1;
        if (arrLen > 1) dp[1] = 1;
        for (int i = 1; i < steps; i++) {
            var ndp = new int[arrLen];
            for (int j = 0; j < arrLen; j++) {
                ndp[j] = dp[j];
                if (j > 0) ndp[j] = (ndp[j] + dp[j - 1]) % mod;
                if (j < arrLen - 1) ndp[j] = (ndp[j] + dp[j + 1]) % mod;
            }
            dp = ndp;
        }
        return dp[0];
    }
}

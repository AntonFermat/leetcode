package leetcode.p1200.p1220;

public class Solution {
    public int countVowelPermutation(int n) {
        int mod = 1_000_000_007;
        long[][] dp = new long[n + 1][5];
        for (int i = 0; i < 5; i++) dp[1][i] = 1;
        for (int i = 1; i < n; i++) {
            dp[i + 1][0] = (dp[i][4] + dp[i][1] + dp[i][2]) % mod;
            dp[i + 1][1] = (dp[i][0] + dp[i][2]) % mod;
            dp[i + 1][2] = (dp[i][3] + dp[i][1]) % mod;
            dp[i + 1][3] = (dp[i][2]) % mod;
            dp[i + 1][4] = (dp[i][2] + dp[i][3]) % mod;
        }
        long res = 0;
        for (int i = 0; i < 5; i++) res = (res + dp[n][i]) % mod;
        return (int) res;
    }
}

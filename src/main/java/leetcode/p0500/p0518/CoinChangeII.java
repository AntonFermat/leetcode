package leetcode.p0500.p0518;

public class CoinChangeII {
    public int change(int amount, int[] coins) {
        var dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = amount; i > 0; i--) {
                for (int j = 1; i - j * coin >= 0; j++) {
                    dp[i] += dp[i - j * coin];
                }
            }
        }
        return dp[amount];
    }
}

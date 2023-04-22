package leetcode.p0800.p0879;

public class ProfitableSchemes {
    private final static int mod = 1_000_000_007;
    private int minProfit;
    private int[] group;
    private int[] profit;
    private int len;
    private Integer[][][] dp;

    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        this.minProfit = minProfit;
        this.group = group;
        this.profit = profit;
        this.len = group.length;
        this.dp = new Integer[n + 1][len][minProfit + 1];
        return helper(n, 0, 0);
    }

    private int helper(int n, int index, int cur) {
        if (index == len) return cur >= minProfit ? 1 : 0;
        if (dp[n][index][cur] != null) return dp[n][index][cur];
        int res = helper(n, index + 1, cur);
        if (n - group[index] >= 0) {
            res = (res + helper(n - group[index], index + 1, Math.min(minProfit, cur + profit[index]))) % mod;
        }

        return dp[n][index][cur] = res;
    }
}

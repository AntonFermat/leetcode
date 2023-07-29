package leetcode.p0800.p0808;

public class SoupServings {
    public double soupServings(int n) {
        n = (n + 24) / 25;
        if (n > 200) return 1.0;
        return soupServings(n, n, new double[n + 1][n + 1]);
    }

    public double soupServings(int a, int b, double[][] dp) {
        if (a <= 0 && b <= 0) return 0.5;
        if (a <= 0 || 4 * a <= b) return 1.0;
        if (b <= 0) return 0.0;

        if (dp[a][b] != 0) return dp[a][b];
        var res = 0.25 * (soupServings(a - 4, b, dp) + soupServings(a - 3, b - 1, dp)
                + soupServings(a - 2, b - 2, dp) + soupServings(a - 1, b - 3, dp));
        return dp[a][b] = res;
    }
}
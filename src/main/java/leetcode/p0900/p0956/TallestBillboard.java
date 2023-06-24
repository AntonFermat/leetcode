package leetcode.p0900.p0956;

public class TallestBillboard {
    public int tallestBillboard(int[] rods) {
        int len = rods.length;
        int sum = 0;
        for (int r : rods) sum += r;
        var dp = new boolean[len + 1][sum + 1];
        var max = new int[len + 1][sum + 1];
        dp[0][sum / 2] = true;
        for (int i = 0; i < len; i++) {
            int r = rods[i];
            for (int j = 0; j < sum; j++) {
                if (j - r >= 0 && dp[i][j - r]) {
                    dp[i + 1][j] = true;
                    max[i + 1][j] = Math.max(max[i + 1][j], max[i][j - r] + r);
                }
                if (j + r < sum && dp[i][j + r]) {
                    dp[i + 1][j] = true;
                    max[i + 1][j] = Math.max(max[i + 1][j], max[i][j + r]);
                }
                if (dp[i][j]) {
                    dp[i + 1][j] = true;
                    max[i + 1][j] = Math.max(max[i + 1][j], max[i][j]);
                }
            }
        }
        return max[len][sum / 2];
    }
}

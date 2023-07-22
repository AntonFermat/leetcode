package leetcode.p0600.p0688;

import java.util.Arrays;

public class KnightProbabilityInChessboard {
    public double knightProbability(int n, int k, int row, int column) {
        var dp = new double[n][n][k + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        return helper(n, k, row, column, dp);
    }

    private double helper(int n, int k, int row, int col, double[][][] dp) {
        if (k == 0) return 1.0;
        if (dp[row][col][k] != -1) return dp[row][col][k];
        var dirs = new int[][]{{1, 2}, {2, 1}, {-1, -2}, {-2, -1}, {-2, 1}, {1, -2}, {2, -1}, {-1, 2}};
        double res = 0.0;
        for (var d : dirs) {
            int nrow = row + d[0];
            int ncol = col + d[1];
            if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < n) {
                res += 0.125 * helper(n, k - 1, nrow, ncol, dp);
            }
        }
        return dp[row][col][k] = res;
    }
}

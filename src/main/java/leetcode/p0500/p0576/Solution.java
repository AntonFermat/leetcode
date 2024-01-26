package leetcode.p0500.p0576;

import java.util.Arrays;

public class Solution {
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        var dp = new long[m][n][maxMove + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) Arrays.fill(dp[i][j], -1L);
        }
        return (int) findPaths(maxMove, startRow, startColumn, dp);
    }

    public long findPaths(int maxMove, int i, int j, long[][][] dp) {
        int m = dp.length, n = dp[0].length;
        if (i < 0 || i == m || j < 0 || j == n) return 1;
        if (maxMove == 0) return 0;

        if (dp[i][j][maxMove] >= 0) return dp[i][j][maxMove];

        dp[i][j][maxMove] = (
                (findPaths(maxMove - 1, i - 1, j, dp) + findPaths(maxMove - 1, i + 1, j, dp))
                        + (findPaths(maxMove - 1, i, j - 1, dp) + findPaths(maxMove - 1, i, j + 1, dp))
        ) % 1_000_000_007;
        return dp[i][j][maxMove];
    }
}

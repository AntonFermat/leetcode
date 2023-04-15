package leetcode.p2200.p2218;

import java.util.List;

public class MaximumValueOfKCoinsFromPiles {
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        int n = piles.size();
        int m = 0;
        for (var p : piles) m = Math.max(m, p.size());
        m = Math.min(m, k);

        var prefix = new int[n][m + 1];
        for (int i = 0; i < n; i++) {
            var p = piles.get(i);
            int plen = p.size();
            for (int j = 0; j < m; j++) {
                prefix[i][j + 1] = prefix[i][j] + (j >= plen ? 0 : p.get(j));
            }
        }
        return helper(prefix, 0, k, new int[n + 1][k + 1]);
    }


    private int helper(int[][] prefix, int index, int k, int[][] dp) {
        int n = prefix.length;
        int m = prefix[0].length;
        if (index == n) return 0;
        int sum = 0;
        for (int i = 0; i < Math.min(m, k + 1); i++) {
            if (dp[index + 1][k - i] == 0) dp[index + 1][k - i] = helper(prefix, index + 1, k - i, dp);
            sum = Math.max(sum, prefix[index][i] + dp[index + 1][k - i]);
        }
        return sum;
    }
}

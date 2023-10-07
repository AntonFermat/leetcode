package leetcode.p1400.p1420;

import java.util.Arrays;

public class Solution {
    private static final int mod = 1_000_000_007;
    private int n, m, k;

    public int numOfArrays(int n, int m, int k) {
        this.n = n;
        this.m = m;
        this.k = k;

        var memo = new int[n][m + 2][k + 1];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m + 2; j++) Arrays.fill(memo[i][j], -1);
        return helper(0, -1, 0, memo);
    }

    private int helper(int index, int max, int score, int[][][] memo) {
        if (max == m && score < k) return 0;
        if (index == n) {
            if (score == k) return 1;
            else return 0;
        }
        if (memo[index][max + 1][score] != -1) return memo[index][max + 1][score];
        int res = 0;
        for (int i = 1; i <= m; i++) {
            if (i > max) {
                if (score + 1 > k) break;
                if (k - score > m - max) break;

                res = (res + helper(index + 1, i, score + 1, memo)) % mod;
            } else res = (res + helper(index + 1, max, score, memo)) % mod;
        }
        return memo[index][max + 1][score] = res;
    }
}

package leetcode.p0900.p0920;

import java.util.Arrays;

public class NumberOfMusicPlaylists {

    public int numMusicPlaylists(int n, int goal, int k) {
        var memo = new int[goal + 1][n + 1];
        for (var m : memo) Arrays.fill(m, -1);
        return (helper(goal, n, k, n, memo));
    }

    private int helper(int i, int j, int k, int n, int[][] memo) {
        if (i == 0 && j == 0) return 1;
        if (i == 0 || j == 0) return 0;

        if (memo[i][j] != -1) return memo[i][j];

        int mod = 1_000_000_007;
        memo[i][j] = (int) (((long) helper(i - 1, j - 1, k, n, memo) * (n - j + 1)) % mod);
        if (j > k) {
            memo[i][j] = (int) (((long) helper(i - 1, j, k, n, memo) * (j - k) + memo[i][j]) % mod);
        }
        return memo[i][j];
    }
}

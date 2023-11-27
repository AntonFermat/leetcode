package leetcode.p0900.p0935;

public class Solution {
    private static final int mod = 1_000_000_007;
    private static final int[][] memo = new int[10][5001];

    public int knightDialer(int n) {
        int res = 0;
        for (int i = 0; i < 10; i++) {

            res = (res + helper(i, n)) % mod;
        }
        return res;
    }

    private int helper(int d, int n) {
        if (n == 1) return 1;
        if (memo[d][n] != 0) return memo[d][n];
        int res = 0;
        var dir = new int[][]{{4, 6}, {6, 8}, {7, 9}, {4, 8}, {0, 3, 9}, {}, {0, 1, 7}, {2, 6}, {1, 3}, {2, 4}};
        for (int x : dir[d]) res = (res + helper(x, n - 1)) % mod;
        return memo[d][n] = res;
    }
}

package leetcode.p0300.p0343;

public class IntegerBreak {
    public int integerBreak(int n) {
        return helper(n, 1, new int[n + 1]);
    }

    private int helper(int n, int k, int[] memo) {
        if (memo[n] != 0) return memo[n];
        int res = k == 1 ? n - 1 : n;
        for (int i = 1; i < n; i++) {
            int x = helper(n - i, k + 1, memo);
            res = Math.max(res, i * x);
        }
        return memo[n] = res;
    }
}

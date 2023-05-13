package leetcode.p2400.p2466;

import java.util.Arrays;

public class CountWaysToBuildGoodStrings {

    private static final int m = 1_000_000_007;
    private int low, high, zero, one;
    private int[] memo;

    public int countGoodStrings(int low, int high, int zero, int one) {
        this.low = low;
        this.high = high;
        this.zero = zero;
        this.one = one;
        this.memo = new int[high + 1];
        Arrays.fill(memo, -1);
        return helper(0);
    }

    private int helper(int len) {
        if (len > high) return 0;
        if (memo[len] != -1) return memo[len];
        int res = ((len < low ? 0 : 1) + helper(len + zero) + helper(len + one)) % m;
        return memo[len] = res;
    }
}
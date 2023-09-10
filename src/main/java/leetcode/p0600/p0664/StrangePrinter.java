package leetcode.p0600.p0664;

public class StrangePrinter {
    public int strangePrinter(String s) {
        int len = s.length();
        return helper(s, 0, len - 1, new int[len][len]) + 1;
    }

    private int helper(String s, int l, int r, int[][] dp) {
        if (dp[l][r] != 0) return dp[l][r];

        int res = s.length();
        int l1 = -1;
        for (int i = l; i < r; i++) {
            if (s.charAt(i) != s.charAt(r) && l1 == -1) l1 = i;
            if (l1 != -1) res = Math.min(res, 1 + helper(s, l1, i, dp) + helper(s, i + 1, r, dp));
        }
        if (l1 == -1) return 0;
        return dp[l][r] = res;
    }
}

package leetcode.p1400.p1416;

public class RestoreTheArray {
    public int numberOfArrays(String s, int k) {
        int len = s.length();
        int left = -1, right = -1, factor = 1, val = 0;
        for (int i = len - 1; i >= 0; i--) {
            int digit = s.charAt(i) - '0';
            if (right == -1 && digit != 0) right = i;
            if (val + factor * digit > k || len - i == 10) break;
            left = i;
            val += factor * digit;
            factor *= 10;
        }
        if (left == -1 || right == -1) return 0;

        return helper(s, k, left, right, 0, new int[len]);
    }

    private final static int mod = 1_000_000_007;

    private int helper(String s, int k, int left, int right, int index, int[] dp) {
        int len = s.length();
        if (index == len || s.charAt(index) == '0') return 0;
        if (dp[index] != 0) return dp[index];
        int res = (index >= left && index <= right) ? 1 : 0;
        long cur = 0;
        for (int i = index; i < len; i++) {
            cur = cur * 10 + (s.charAt(i) - '0');
            if (cur > k || i - index == 10) break;
            res = (res + helper(s, k, left, right, i + 1, dp)) % mod;
        }
        return dp[index] = res;
    }
}

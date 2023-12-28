package leetcode.p1500.p1531;

public class Solution {
    private String s;
    private int len;
    private Integer[][][][] dp;

    public int getLengthOfOptimalCompression(String s, int k) {
        this.s = s;
        this.len = s.length();
        this.dp = new Integer[27][len][len][k + 1];
        return helper((char) ('z' + 1), 0, 0, k);
    }

    private int helper(char prev, int prevCount, int index, int k) {
        if (k == -1) return len;
        if (index == len) return 0;
        if (dp[prev - 'a'][prevCount][index][k] != null) return dp[prev - 'a'][prevCount][index][k];
        char cur = s.charAt(index);
        int res = helper(prev, prevCount, index + 1, k - 1);
        if (prev == cur) {
            res = Math.min(res, helper(prev, prevCount + 1, index + 1, k) +
                    ((prevCount == 1 || prevCount == 9 || prevCount == 99) ? 1 : 0));
        } else {
            res = Math.min(res, 1 + helper(cur, 1, index + 1, k));
        }

        return dp[prev - 'a'][prevCount][index][k] = res;
    }
}

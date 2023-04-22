package leetcode.p1300.p1312;

public class MinimumInsertionStepsToMakeAStringPalindrome {
    public int minInsertions(String s) {
        int len = s.length();
        var dp = new int[len + 1][len + 1];
        int x = 0;
        for (int i = len - 1; i >= 0; i--) {
            for (int j = len - 1; j >= 0; j--) {
                if (s.charAt(i) == s.charAt(len - 1 - j)) {
                    dp[i][j] = 1 + dp[i + 1][j + 1];
                    x = Math.max(x, dp[i][j]);
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }
        return len - dp[0][0];
    }
}

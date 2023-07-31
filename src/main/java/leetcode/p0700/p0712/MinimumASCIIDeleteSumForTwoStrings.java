package leetcode.p0700.p0712;

public class MinimumASCIIDeleteSumForTwoStrings {
    public int minimumDeleteSum(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();

        int sum = 0;
        for (int i = 0; i < len1; i++) sum += s1.charAt(i);
        for (int i = 0; i < len2; i++) sum += s2.charAt(i);

        var dp = new int[len1 + 1][len2 + 1];
        for (int i = len1 - 1; i >= 0; i--) {
            int x1 = s1.charAt(i);
            for (int j = len2 - 1; j >= 0; j--) {
                int x2 = s2.charAt(j);
                if (x1 == x2) {
                    dp[i][j] = x1 + x2 + dp[i + 1][j + 1];
                } else dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);
            }
        }
        return sum - dp[0][0];
    }
}

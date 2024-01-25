package leetcode.p1100.p1143;

public class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n1 = text1.length(), n2 = text2.length();
        if (n1 < n2) return longestCommonSubsequence(text2, text1);
        var dp = new int[n2 + 1];
        for (int i = 0; i < text1.length(); i++) {
            var ndp = new int[n2 + 1];
            for (int j = 0; j < n2; j++) {
                if (text1.charAt(i) == text2.charAt(j)) ndp[j + 1] = 1 + dp[j];
                else ndp[j + 1] = Math.max(ndp[j], dp[j + 1]);
            }
            dp = ndp;
        }
        return dp[n2];
    }
}

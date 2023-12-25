package leetcode.p0000.p0091;

public class Solution {
    public int numDecodings(String s) {
        if (s.startsWith("0")) return 0;
        int len = s.length();
        var arr = new int[len];
        for (int i = 0; i < len; i++) arr[i] = s.charAt(i) - '0';
        return numDecodings(arr, len - 1, new int[len]);
    }

    private int numDecodings(int[] arr, int i, int[] dp) {
        if (i <= 0) return 1;
        int res = 0;
        if (arr[i] != 0) {
            if (dp[i - 1] == 0) {
                dp[i - 1] = numDecodings(arr, i - 1, dp);
            }
            res += dp[i - 1];
        }

        if (arr[i - 1] != 0 && arr[i - 1] * 10 + arr[i] <= 26) {
            if (i - 2 > 0 && dp[i - 2] == 0) {
                dp[i - 2] = numDecodings(arr, i - 2, dp);
            }
            res += i - 2 > 0 ? dp[i - 2] : 1;
        }
        return res;
    }
}

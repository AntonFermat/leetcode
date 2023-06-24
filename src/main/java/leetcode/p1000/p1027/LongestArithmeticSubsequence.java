package leetcode.p1000.p1027;

import java.util.Arrays;

public class LongestArithmeticSubsequence {
    public int longestArithSeqLength(int[] nums) {
        int len = nums.length;
        var dp = new int[len][1001];
        for (int i = 0; i < len; i++) Arrays.fill(dp[i], 1);
        int res = 1;
        for (int i = 0; i < len; i++) {
            int numi = nums[i];
            for (int j = i + 1; j < len; j++) {
                int numj = nums[j];
                int diff = numj - numi + 500;
                dp[j][diff] = dp[i][diff] + 1;
                res = Math.max(res, dp[j][diff]);
            }
        }
        return res;
    }
}

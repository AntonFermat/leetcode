package leetcode.p0600.p0673;

public class NumberOfLongestIncreasingSubsequence {
    public int findNumberOfLIS(int[] nums) {
        int len = nums.length;
        var dp = new int[len][2];
        int max = 1;
        for (int i = 0; i < len; i++) {
            helper(nums, dp, i);
            max = Math.max(max, dp[i][0]);
        }
        int res = 0;
        for (int[] val : dp) {
            if (val[0] == max) res += val[1];
        }
        return res;
    }

    private void helper(int[] nums, int[][] dp, int index) {
        if (dp[index][0] != 0) return;
        dp[index] = new int[]{1, 1};
        for (int i = 0; i < index; i++) {
            if (nums[i] < nums[index]) {
                helper(nums, dp, i);
                if (dp[i][0] + 1 > dp[index][0]) {
                    dp[index][0] = dp[i][0] + 1;
                    dp[index][1] = 0;
                }
                if (dp[i][0] + 1 == dp[index][0]) dp[index][1] += dp[i][1];
            }
        }
    }
}

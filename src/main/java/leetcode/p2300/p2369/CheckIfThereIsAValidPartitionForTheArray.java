package leetcode.p2300.p2369;

public class CheckIfThereIsAValidPartitionForTheArray {
    public boolean validPartition(int[] nums) {
        int l = nums.length;
        if (l == 2) return nums[0] == nums[1];
        var dp = new boolean[l + 1];
        dp[0] = true;
        for (int i = 2; i < l + 1; i++) {
            dp[i] = dp[i] || nums[i - 1] == nums[i - 2] && dp[i - 2];
            dp[i] = dp[i] || i > 2 && nums[i - 1] == nums[i - 2] && nums[i - 2] == nums[i - 3] && dp[i - 3];
            dp[i] = dp[i] || i > 2 && nums[i - 1] - nums[i - 2] == 1 && nums[i - 2] - nums[i - 3] == 1 && dp[i - 3];
        }
        return dp[l];
    }
}

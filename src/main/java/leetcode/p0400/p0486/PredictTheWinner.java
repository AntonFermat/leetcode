package leetcode.p0400.p0486;

import java.util.Arrays;

public class PredictTheWinner {
    public boolean predictTheWinner(int[] nums) {
        int len = nums.length;
        var memo = new int[len][len];
        for (var m : memo) Arrays.fill(m, -1);
        return helper(nums, 0, nums.length - 1, memo) >= 0;
    }

    private int helper(int[] nums, int l, int r, int[][] memo) {
        if (l == r) return nums[l];
        if (memo[l][r] != -1) return memo[l][r];
        return memo[l][r] = Math.max(nums[l] - helper(nums, l + 1, r, memo),
                nums[r] - helper(nums, l, r - 1, memo));

    }
}

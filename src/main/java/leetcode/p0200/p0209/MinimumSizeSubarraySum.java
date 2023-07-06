package leetcode.p0200.p0209;

public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int target, int[] nums) {
        int len = nums.length;
        int res = Integer.MAX_VALUE, sum = 0;
        for (int i = 0, j = 0; i < len; i++) {
            sum += nums[i];
            while (sum >= target) {
                res = Math.min(res, i - j + 1);
                sum -= nums[j++];
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}

package leetcode.p2000.p2090;

import java.util.Arrays;

public class KRadiusSubarrayAverages {
    public int[] getAverages(int[] nums, int k) {
        int len = nums.length;
        var res = new int[len];
        Arrays.fill(res, -1);
        if (len < 2 * k + 1) return res;

        long sum = 0;
        for (int i = 0; i < 2 * k; i++) sum += nums[i];
        for (int i = k; i < len - k; i++) {
            sum += nums[i + k];
            res[i] = (int) (sum / (2L * k + 1));
            sum -= nums[i - k];
        }
        return res;
    }
}

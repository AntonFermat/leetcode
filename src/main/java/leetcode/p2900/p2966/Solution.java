package leetcode.p2900.p2966;

import java.util.Arrays;

public class Solution {
    public int[][] divideArray(int[] nums, int k) {
        Arrays.sort(nums);
        int len = nums.length;
        var res = new int[len / 3][3];
        for (int i = 0; i < len; i += 3) {
            if (nums[i + 2] - nums[i] > k) return new int[][]{};
            res[i / 3] = new int[]{nums[i], nums[i + 1], nums[i + 2]};
        }
        return res;
    }
}

package leetcode.p1800.p1838;

import java.util.Arrays;

public class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0, sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if ((i - left + 1) * nums[i] - sum > k) sum -= nums[left++];
        }
        return nums.length - left;
    }
}

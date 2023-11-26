package leetcode.p1600.p1685;

public class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int len = nums.length;
        int sum = 0;
        for (int num : nums) sum += num;

        var res = new int[len];
        int prev = 0;
        for (int i = 0; i < len; i++) {
            res[i] = sum - prev * 2 + nums[i] * (i * 2 - len);
            prev += nums[i];
        }
        return res;
    }
}

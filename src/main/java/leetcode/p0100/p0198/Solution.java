package leetcode.p0100.p0198;

public class Solution {
    public int rob(int[] nums) {
        int res = 0, prev = 0;
        for (int num : nums) {
            int cur = Math.max(prev + num, res);
            prev = res;
            res = cur;
        }
        return res;
    }
}

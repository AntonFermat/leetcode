package leetcode.p1400.p1493;

public class LongestSubarrayOf1sAfterDeletingOneElement {
    public int longestSubarray(int[] nums) {
        int len = nums.length;
        int res = 0, l1 = 0, l2 = 0;
        for (int n : nums) {
            if (n == 0) {
                l2 = l1;
                l1 = 0;
            } else {
                l1++;
                l2++;
            }
            res = Math.max(res, l2);
        }
        return l1 == len ? l1 - 1 : Math.max(res, l1);
    }
}

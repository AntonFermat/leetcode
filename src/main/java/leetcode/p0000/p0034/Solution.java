package leetcode.p0000.p0034;

public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int len = nums.length;
        var res = new int[]{0, len - 1};
        boolean contains = false;
        int l = 0, r = len - 1;
        while (l <= r) {
            int m = r - (r - l) / 2;
            int val = nums[m];
            if (val == target) {
                contains = true;
                r = m - 1;
                res[0] = m;
            } else if (val < target) l = m + 1;
            else r = m - 1;
        }
        if (!contains) return new int[]{-1, -1};
        r = len - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            int val = nums[m];
            if (val == target) {
                l = m + 1;
                res[1] = m;
            } else if (val < target) l = m + 1;
            else r = m - 1;
        }
        return res;
    }
}

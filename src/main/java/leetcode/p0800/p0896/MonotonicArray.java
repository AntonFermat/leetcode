package leetcode.p0800.p0896;

public class MonotonicArray {
    public boolean isMonotonic(int[] nums) {
        int prev = 0;
        for (int i = 1; i < nums.length; ++i) {
            int cur = Integer.compare(nums[i - 1], nums[i]);
            if (cur != 0) {
                if (cur != prev && prev != 0) return false;
                prev = cur;
            }
        }
        return true;
    }
}

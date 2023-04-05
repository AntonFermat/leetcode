package leetcode.p2400.p2439;

public class MinimizeMaximumOfArray {
    public int minimizeArrayValue(int[] nums) {
        int len = nums.length;
        int right = 0;
        long sum = 0;
        for (int num : nums) {
            right = Math.max(right, num);
            sum += num;
        }
        int left = (int) (sum / len);
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isPossible(nums, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }

    private boolean isPossible(int[] nums, int max) {
        long extra = 0;
        for (int num : nums) {
            int diff = num - max;
            if (diff > 0 && diff > extra) return false;
            extra -= diff;
        }
        return true;
    }
}

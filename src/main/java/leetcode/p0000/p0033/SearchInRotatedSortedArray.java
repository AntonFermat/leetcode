package leetcode.p0000.p0033;

public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        int x;

        while (l < r) {
            x = (l + r) / 2;
            if (nums[x] > nums[r]) {
                l = x + 1;
            } else {
                r = x;
            }
        }

        x = l;
        l = 0;
        r = nums.length - 1;

        if (target >= nums[x] && target <= nums[r]) l = x;
        else r = x;

        int m;
        while (l <= r) {
            m = (l + r) / 2;
            if (nums[m] == target) return m;
            else if (nums[m] > target) r = m - 1;
            else l = m + 1;
        }

        return -1;
    }
}

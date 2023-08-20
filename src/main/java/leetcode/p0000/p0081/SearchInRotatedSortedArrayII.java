package leetcode.p0000.p0081;

public class SearchInRotatedSortedArrayII {
    public boolean search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (nums[m] == target) return true;
            if (nums[l] > nums[m] || nums[m] < nums[r]) {
                if (target > nums[m] && target <= nums[r]) l = m + 1;
                else r = m - 1;
            } else if (nums[l] < nums[m] || nums[m] > nums[r]) {
                if (target < nums[m] && target >= nums[l]) r = m - 1;
                else l = m + 1;
            } else r--;
        }
        return false;
    }
}

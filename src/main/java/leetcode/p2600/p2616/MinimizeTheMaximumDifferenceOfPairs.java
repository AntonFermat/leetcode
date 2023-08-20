package leetcode.p2600.p2616;

import java.util.Arrays;

public class MinimizeTheMaximumDifferenceOfPairs {
    public int minimizeMax(int[] nums, int p) {
        if (p == 0) return 0;
        Arrays.sort(nums);
        int len = nums.length;

        int l = 0, r = 0;
        for (int i = 0; i < len - 1; i++) {
            r = Math.max(r, nums[i + 1] - nums[i]);
        }

        while (l < r) {
            int m = l + (r - l) / 2;
            if (!isPossible(nums, m, p)) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return l;
    }

    private boolean isPossible(int[] nums, int m, int p) {
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] - nums[i] <= m) {
                count++;
                i++;
                if (count == p) return true;
            }
        }
        return false;
    }
}

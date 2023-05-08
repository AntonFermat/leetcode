package leetcode.p1400.p1498;

import java.util.*;

public class NumberOfSubsequencesThatSatisfyTheGivenSumCondition {

    private static final List<Integer> x2 = new ArrayList<>();

    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        int m = 1_000_000_007;
        int len = nums.length;
        if (x2.isEmpty()) x2.add(1);
        if (x2.size() < len) {
            for (int i = x2.size(); i < len; i++) {
                x2.add(x2.get(i - 1) * 2 % m);
            }
        }
        int res = 0;
        int l = 0, r = len - 1;
        while (l <= r) {
            if (nums[l] + nums[r] <= target) {
                res = (res + x2.get(r - l)) % m;
                l++;
            } else r--;
        }
        return res;
    }
}

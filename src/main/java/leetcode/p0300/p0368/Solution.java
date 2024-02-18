package leetcode.p0300.p0368;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);
        var res = new ArrayList<Integer>();
        var arr = new int[len];
        int max = 0;
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                if (nums[j] % nums[i] == 0) {
                    arr[i] = Math.max(arr[i], arr[j] + 1);
                    max = Math.max(max, arr[i]);
                }
            }
        }
        int prev = 1;
        for (int i = 0; i < len; i++) {
            if (arr[i] == max && nums[i] % prev == 0) {
                res.add(nums[i]);
                prev = nums[i];
                max--;
            }
        }

        return res;
    }
}

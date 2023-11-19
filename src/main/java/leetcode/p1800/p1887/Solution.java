package leetcode.p1800.p1887;

import java.util.*;

public class Solution {
    public int reductionOperations(int[] nums) {
        Arrays.sort(nums);
        int res = 0;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] != nums[i + 1]) res += (nums.length - 1 - i);
        }
        return res;
    }
}

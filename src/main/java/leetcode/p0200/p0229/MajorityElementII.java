package leetcode.p0200.p0229;

import java.util.*;

public class MajorityElementII {
    public List<Integer> majorityElement(int[] nums) {
        int len = nums.length;
        if (len == 1) return List.of(nums[0]);

        int val1 = nums[0], count1 = 0, val2 = nums[1], count2 = 0;
        for (int num : nums) {
            if (num == val1) count1++;
            else if (num == val2) count2++;
            else if (count1 == 0) {
                val1 = num;
                count1 = 1;
            } else if (count2 == 0) {
                val2 = num;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }
        count1 = 0;
        count2 = 0;
        for (int num : nums) {
            if (num == val1) count1++;
            else if (num == val2) count2++;
        }
        var res = new ArrayList<Integer>();
        if (count1 > len / 3) res.add(val1);
        if (count2 > len / 3) res.add(val2);
        return res;
    }
}

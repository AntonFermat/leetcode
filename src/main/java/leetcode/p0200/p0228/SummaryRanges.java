package leetcode.p0200.p0228;

import java.util.*;

public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        int len = nums.length;
        var res = new ArrayList<String>();
        if (len == 0) return res;
        if (len == 1) {
            res.add(String.valueOf(nums[0]));
            return res;
        }
        int prev = nums[0];
        for (int i = 1; i < len + 1; i++) {
            if (i == len || nums[i] - nums[i - 1] != 1) {
                if (prev == nums[i - 1])
                    res.add(String.valueOf(nums[i - 1]));
                else
                    res.add(prev + "->" + nums[i - 1]);

                if (i < len)
                    prev = nums[i];
            }
        }
        return res;
    }
}

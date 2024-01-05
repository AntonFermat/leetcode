package leetcode.p0300.p0300;

import java.util.*;

public class Solution {
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        var list = new LinkedList<>(List.of(nums[0]));
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            if (num > list.getLast()) list.add(num);
            else {
                int index = Collections.binarySearch(list, num);
                list.set(index < 0 ? -index - 1 : index, num);
            }
        }
        return list.size();
    }
}

package leetcode.p0400.p0456;

import java.util.*;

public class Pattern132 {
    public boolean find132pattern(int[] nums) {
        int len = nums.length;
        if (len < 3) return false;
        var right = new TreeMap<Integer, Integer>();
        for (int num : nums) right.put(num, right.getOrDefault(num, 0) + 1);
        var min = Integer.MAX_VALUE;
        for (int num : nums) {
            if (right.get(num) == 1) right.remove(num);
            else right.put(num, right.get(num) - 1);
            var floor = right.floorKey(num - 1);
            if (floor != null && min < floor && num > floor) return true;
            min = Math.min(min, num);
        }
        return false;
    }
}

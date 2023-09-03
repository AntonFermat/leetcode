package leetcode.p0200.p0239;

import java.util.TreeMap;

public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        var res = new int[len + 1 - k];
        var map = new TreeMap<Integer, Integer>();
        for (int i = 0; i < len; i++) {
            int num = nums[i];
            map.put(num, map.getOrDefault(num, 0) + 1);
            if (i >= k - 1) {
                res[i + 1 - k] = map.lastKey();
                int prev = nums[i + 1 - k];
                int count = map.get(prev) - 1;
                if (count == 0) map.remove(prev);
                else map.put(prev, count);
            }
        }
        return res;
    }
}

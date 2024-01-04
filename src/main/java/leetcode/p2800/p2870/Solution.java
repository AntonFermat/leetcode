package leetcode.p2800.p2870;

import java.util.*;

public class Solution {
    public int minOperations(int[] nums) {
        var map = new HashMap<Integer, Integer>();
        for (int num : nums) map.put(num, map.getOrDefault(num, 0) + 1);
        int res = 0;
        for (int count : map.values()) {
            if (count == 1) return -1;
            else if (count == 2 || count == 3) res++;
            else res += (count / 3) + (count % 3 == 0 ? 0 : 1);
        }
        return res;
    }
}

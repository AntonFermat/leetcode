package leetcode.p1800.p1814;

import java.util.*;

public class Solution {
    public int countNicePairs(int[] nums) {
        int res = 0;
        var map = new HashMap<Integer, Integer>();
        for (int num : nums) {
            res = (res + map.merge(num - Integer.parseInt(new StringBuilder().append(num).reverse().toString()), 1, (i, j) -> i + 1) - 1) % 1_000_000_007;
        }
        return res;
    }
}

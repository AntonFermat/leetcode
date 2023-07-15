package leetcode.p1200.p1218;

import java.util.HashMap;

public class LongestArithmeticSubsequenceOfGivenDifference {
    public int longestSubsequence(int[] arr, int difference) {
        int res = 1;
        var map = new HashMap<Integer, Integer>();
        for (int num : arr) {
            int length = map.getOrDefault(num - difference, 0) + 1;
            map.put(num, length);
            res = Math.max(res, length);
        }

        return res;
    }
}

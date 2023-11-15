package leetcode.p1800.p1846;

import java.util.Arrays;

public class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        int res = 0;
        Arrays.sort(arr);
        for (int a : arr) if (a != res) res++;
        return res;
    }
}
package leetcode.p1500.p1503;

import java.util.Arrays;

public class Solution {
    public int getLastMoment(int n, int[] left, int[] right) {
        return Math.max(Arrays.stream(left).max().orElse(0), n - Arrays.stream(right).min().orElse(n));
    }
}

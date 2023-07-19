package leetcode.p0400.p0435;

import java.util.Arrays;
import java.util.Comparator;

public class NonOverlappingIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(i -> i[1]));
        int res = 0;
        int[] prev = null;
        for (var inter : intervals) {
            int start = inter[0], end = inter[1];
            if (prev != null && start < prev[1]) {
                res++;
            } else prev = inter;
        }

        return res;
    }
}

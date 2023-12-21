package leetcode.p1600.p1637;

import java.util.*;

public class Solution {
    public int maxWidthOfVerticalArea(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(p -> p[0]));
        int res = 0;
        for (int i = 1; i < points.length; i++) {
            res = Math.max(res, points[i][0] - points[i - 1][0]);
        }
        return res;
    }
}

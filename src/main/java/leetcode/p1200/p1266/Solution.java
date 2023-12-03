package leetcode.p1200.p1266;

public class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int res = 0;
        for (int i = 1; i < points.length; i++) {
            var p1 = points[i - 1];
            var p2 = points[i];
            res += Math.max(Math.abs(p1[0] - p2[0]), Math.abs(p1[1] - p2[1]));
        }
        return res;
    }
}

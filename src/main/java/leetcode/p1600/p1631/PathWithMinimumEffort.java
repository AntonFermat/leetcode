package leetcode.p1600.p1631;

import java.util.*;

public class PathWithMinimumEffort {
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        var memo = new int[m][n];
        for (int i = 0; i < m; i++) Arrays.fill(memo[i], Integer.MAX_VALUE);
        memo[0][0] = 0;
        var dirs = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        var q = new LinkedList<int[]>();
        q.add(new int[]{0, 0});
        while (!q.isEmpty()) {
            var cur = q.poll();
            int x = cur[0], y = cur[1];
            for (var d : dirs) {
                int nx = x + d[0], ny = y + d[1];
                if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                    int effort = Math.max(memo[x][y], Math.abs(heights[x][y] - heights[nx][ny]));
                    if (effort < memo[nx][ny]) {
                        q.add(new int[]{nx, ny});
                        memo[nx][ny] = effort;
                    }
                }
            }
        }
        return memo[m - 1][n - 1];
    }
}

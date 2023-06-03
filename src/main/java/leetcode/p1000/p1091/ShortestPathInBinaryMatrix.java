package leetcode.p1000.p1091;

import java.util.*;

public class ShortestPathInBinaryMatrix {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) return -1;
        var dirs = new int[][]{{0, 1}, {1, 1}, {1, 0}, {0, -1}, {-1, -1}, {-1, 0}, {-1, 1}, {1, -1}};

        var q = new LinkedList<int[]>();
        q.add(new int[]{0, 0, 1});
        grid[0][0] = 1;

        while (!q.isEmpty()) {
            var pop = q.pop();
            int i = pop[0], j = pop[1];
            int dist = pop[2];
            if (i == n - 1 && j == n - 1) return dist;

            for (var d : dirs) {
                int newi = i + d[0], newj = j + d[1];
                if (newi < 0 || newi > n - 1 || newj < 0 || newj > n - 1 || grid[newi][newj] == 1) continue;
                q.add(new int[]{newi, newj, dist + 1});
                grid[newi][newj] = 1;
            }
        }

        return -1;
    }
}

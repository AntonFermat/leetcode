package leetcode.p0900.p0934;

import java.util.*;

public class ShortestBridge {
    public int shortestBridge(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        var q = new LinkedList<int[]>();
        var visited = new boolean[m][n];
        boolean init = false;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, visited, q, i, j);
                    init = true;
                    break;
                }
            }
            if (init) break;
        }

        while (!q.isEmpty()) {
            var pop = q.pop();
            int i = pop[0], j = pop[1], dist = pop[2];

            for (var d : dirs) {
                int newi = i + d[0];
                int newj = j + d[1];
                int newdist = dist + 1;
                if (newi >= 0 && newi <= m - 1 && newj >= 0 && newj <= n - 1 && !visited[newi][newj]) {

                    if (grid[newi][newj] == 1 && !visited[newi][newj]) return dist;

                    q.add(new int[]{newi, newj, newdist});
                    visited[newi][newj] = true;
                }
            }
        }

        return -1;
    }

    private final int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    private void dfs(int[][] grid, boolean[][] visited, LinkedList<int[]> q, int i, int j) {
        int m = grid.length, n = grid[0].length;
        if (i < 0 || i > m - 1 || j < 0 || j > n - 1 || visited[i][j] || grid[i][j] == 0) return;
        visited[i][j] = true;
        q.add(new int[]{i, j, 0});
        for (var d : dirs) {
            dfs(grid, visited, q, i + d[0], j + d[1]);
        }
    }
}

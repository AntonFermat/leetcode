package leetcode.p0500.p0547;

public class NumberOfProvinces {
    public int findCircleNum(int[][] isConnected) {
        int m = isConnected.length, n = isConnected[0].length;
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                if (isConnected[i][j] == 1) {
                    res++;
                    dfs(isConnected, i, j);
                }
            }
        }
        return res;
    }

    private void dfs(int[][] grid, int x, int y) {
        int m = grid.length, n = grid[0].length;
        if (x < 0 || x == m || y < 0 || y == n || grid[x][y] != 1) return;
        grid[x][y] = 0;
        for (int i = 0; i < m; i++) {
            if (grid[i][y] == 1) dfs(grid, i, y);
        }
        for (int j = 0; j < n; j++) {
            if (grid[x][j] == 1) dfs(grid, x, j);
        }
    }
}

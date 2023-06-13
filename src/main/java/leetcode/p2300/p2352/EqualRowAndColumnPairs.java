package leetcode.p2300.p2352;

public class EqualRowAndColumnPairs {
    public int equalPairs(int[][] grid) {
        int len = grid.length;
        int res = 0;
        var row = new int[len];
        var col = new int[len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                row[i] += grid[i][j];
                col[j] += grid[i][j];
            }
        }
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (row[i] == col[j] && equalPairs(grid, i, j)) res++;
            }
        }
        return res;
    }

    public boolean equalPairs(int[][] grid, int k, int l) {
        for (int i = 0; i < grid.length; i++) {
            if (grid[i][l] != grid[k][i]) return false;
        }
        return true;
    }
}

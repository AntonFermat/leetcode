package leetcode.p2400.p2482;

public class Solution {
    public int[][] onesMinusZeros(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        var row = new int[m];
        var col = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                row[i] += (grid[i][j] == 1) ? 1 : -1;
                col[j] += (grid[i][j] == 1) ? 1 : -1;
            }
        }
        var res = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) res[i][j] = row[i] + col[j];
        }
        return res;
    }
}

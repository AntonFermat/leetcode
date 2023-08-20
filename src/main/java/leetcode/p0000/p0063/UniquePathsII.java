package leetcode.p0000.p0063;

public class UniquePathsII {
    private int[][] obstacleGrid;
    private int[][] cache;

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        if (obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1) {
            return 0;
        }
        this.obstacleGrid = obstacleGrid;
        this.cache = new int[m][n];
        return uniquePathsWithObstacles(0, 0);
    }

    public int uniquePathsWithObstacles(int i, int j) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        if (i + 1 == m && j + 1 == n) {
            cache[i][j] = 1;
            return 1;
        }

        int res = 0;
        if (i + 1 < m) {
            if (obstacleGrid[i + 1][j] == 0 && cache[i + 1][j] == 0) {
                cache[i + 1][j] = uniquePathsWithObstacles(i + 1, j);
            }
            res += cache[i + 1][j];
        }
        if (j + 1 < n) {
            if (obstacleGrid[i][j + 1] == 0 && cache[i][j + 1] == 0) {
                cache[i][j + 1] = uniquePathsWithObstacles(i, j + 1);
            }
            res += cache[i][j + 1];
        }
        return res;
    }
}

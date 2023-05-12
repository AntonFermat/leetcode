package leetcode.p0000.p0059;

public class SpiralMatrixII {
    public int[][] generateMatrix(int n) {
        var res = new int[n][n];
        var dir = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int x = 0, y = 0, d = 0;
        for (int i = 0; i < n * n; i++) {
            res[x][y] = i + 1;
            int x1 = x + dir[d][0];
            int y1 = y + dir[d][1];
            if (x1 < 0 || x1 == n || y1 < 0 || y1 == n || res[x1][y1] != 0) {
                d = (d + 1) % 4;
            }
            x += dir[d][0];
            y += dir[d][1];
        }
        return res;
    }
}

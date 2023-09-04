package leetcode.p0500.p0542;

import java.util.Arrays;

public class Matrix01 {
    public int[][] updateMatrix(int[][] matrix) {
        int rows = matrix.length;
        if (rows == 0) return matrix;
        int cols = matrix[0].length;
        var dist = new int[rows][cols];
        for (int i = 0; i < rows; i++) Arrays.fill(dist[i], 100_000_000);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    dist[i][j] = 0;
                } else {
                    if (i > 0) dist[i][j] = Math.min(dist[i][j], dist[i - 1][j] + 1);
                    if (j > 0) dist[i][j] = Math.min(dist[i][j], dist[i][j - 1] + 1);
                }
            }
        }
        for (int i = rows - 1; i >= 0; i--) {
            for (int j = cols - 1; j >= 0; j--) {
                if (i < rows - 1) dist[i][j] = Math.min(dist[i][j], dist[i + 1][j] + 1);
                if (j < cols - 1) dist[i][j] = Math.min(dist[i][j], dist[i][j + 1] + 1);
            }
        }
        return dist;
    }
}

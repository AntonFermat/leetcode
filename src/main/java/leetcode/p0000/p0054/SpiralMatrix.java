package leetcode.p0000.p0054;

import java.util.*;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        var seen = new boolean[m][n];
        var res = new ArrayList<Integer>();
        var dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int dir = 0;
        int i = 0, j = 0;
        for (int x = 0; x < m * n; x++) {
            res.add(matrix[i][j]);
            seen[i][j] = true;
            int a = i + dirs[dir][0];
            int b = j + dirs[dir][1];
            if (a == -1 || a == m || b == -1 || b == n || seen[a][b]) {
                dir = (dir + 1) % 4;
                a = i + dirs[dir][0];
                b = j + dirs[dir][1];
            }
            i = a;
            j = b;
        }
        return res;
    }
}

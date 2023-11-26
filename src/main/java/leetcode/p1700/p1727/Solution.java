package leetcode.p1700.p1727;

import java.util.Arrays;

public class Solution {
    public int largestSubmatrix(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        var prefix = new int[m][n];
        System.arraycopy(matrix[0], 0, prefix[0], 0, n);
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                prefix[i][j] = (matrix[i][j] == 1) ? prefix[i - 1][j] + 1 : 0;
            }
        }
        int res = 0;
        for (int i = 0; i < m; i++) {
            var row = prefix[i];
            Arrays.sort(row);
            for (int j = 0; j < n; j++) {
                res = Math.max(res, row[j] * (n - j));
            }
        }
        return res;
    }
}

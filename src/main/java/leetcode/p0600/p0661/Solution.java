package leetcode.p0600.p0661;

public class Solution {
    public int[][] imageSmoother(int[][] img) {
        int m = img.length, n = img[0].length;
        var res = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int sum = 0, count = 0;
                for (int k = Math.max(0, i - 1); k <= Math.min(i + 1, m - 1); k++) {
                    for (int l = Math.max(0, j - 1); l <= Math.min(j + 1, n - 1); l++) {
                        sum += img[k][l];
                        count++;
                    }
                }
                res[i][j] = sum / count;
            }
        }
        return res;
    }
}

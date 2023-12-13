package leetcode.p1500.p1582;

public class Solution {
    public int numSpecial(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        var rows = new int[m];
        var cols = new int[n];
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                rows[i] += mat[i][j];
                cols[j] += mat[i][j];
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1 && rows[i] == 1 && cols[j] == 1) res++;
            }
        }
        return res;
    }
}

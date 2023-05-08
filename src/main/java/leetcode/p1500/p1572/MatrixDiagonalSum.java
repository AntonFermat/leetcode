package leetcode.p1500.p1572;

public class MatrixDiagonalSum {
    public int diagonalSum(int[][] mat) {
        int n = mat.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            res += mat[i][i];
            res += mat[n - 1 - i][i];
        }
        return res - (n % 2 == 0 ? 0 : mat[n / 2][n / 2]);
    }
}

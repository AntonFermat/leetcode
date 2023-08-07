package leetcode.p0000.p0074;

public class SearchA2DMatrix {
    public boolean searchMatrix(int[][] mx, int t) {
        int m = mx.length, n = mx[0].length;
        int l = 0, r = m * n - 1;
        while (l <= r) {
            int x = l + (r - l) / 2;
            int val = mx[x / n][x % n];

            if (val == t) return true;
            else if (val > t) r = x - 1;
            else l = x + 1;
        }
        return false;
    }
}

package leetcode.p1300.p1351;

public class CountNegativeNumbersInASortedMatrix {
    public int countNegatives(int[][] grid) {
        int res = 0;
        int n = grid[0].length, r = n - 1;
        for (int[] row : grid) {
            if (row[0] < 0) res += n;
            else if (row[n - 1] < 0) {
                int l = 0;
                while (l < r) {
                    int mid = l + (r - l);
                    if (row[mid] >= 0) {
                        l = mid;
                    } else r = mid - 1;
                }
                res += (n - 1 - l);
            }
        }
        return res;
    }
}

package leetcode.p1000.p1074;

import java.util.HashMap;

public class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int res = 0, m = matrix.length, n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 1; j < n; j++) {
                matrix[i][j] += matrix[i][j - 1];
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                var count = new HashMap<Integer, Integer>();
                count.put(0, 1);
                int cur = 0;
                for (int[] ints : matrix) {
                    cur += ints[j] - (i == 0 ? 0 : ints[i - 1]);
                    res += count.getOrDefault(cur - target, 0);
                    count.put(cur, count.getOrDefault(cur, 0) + 1);
                }
            }
        }
        return res;
    }
}

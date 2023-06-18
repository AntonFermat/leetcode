package leetcode.p2300.p2328;

import java.util.*;

public class NumberOfIncreasingPathsInAGrid {
    public int countPaths(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int mod = 1_000_000_007;
        int[][] memo = new int[m][n];
        int res = 0;
        var dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        var list = new ArrayList<Pair<Integer, Integer>>();
        for (int i = 0; i < m; i++) {
            Arrays.fill(memo[i], 1);
            for (int j = 0; j < n; j++) {
                list.add(new Pair<>(i, j));
            }
        }
        list.sort(Comparator.comparingInt(p -> grid[p.key][p.value]));

        for (var pair : list) {
            int x = pair.key();
            int y = pair.value;
            for (var d : dirs) {
                int newx = x + d[0];
                int newy = y + d[1];
                if (newx >= 0 && newx < m && newy >= 0 && newy < n
                        && grid[x][y] < grid[newx][newy]) memo[newx][newy] = (memo[newx][newy] + memo[x][y]) % mod;
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res = (res + memo[i][j]) % mod;
            }
        }
        return res;
    }

    private record Pair<E, P>(E key, P value) {
    }
}

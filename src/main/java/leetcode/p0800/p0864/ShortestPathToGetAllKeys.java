package leetcode.p0800.p0864;

import java.util.*;

public class ShortestPathToGetAllKeys {

    public int shortestPathAllKeys(String[] grid) {
        int m = grid.length, n = grid[0].length();
        var board = new char[m][n];
        int keyCount = 0;
        int[] start = null;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = grid[i].charAt(j);
                if (board[i][j] == '@') start = new int[]{i, j};
                else if (Character.isAlphabetic(board[i][j]) && Character.isLowerCase(board[i][j])) {
                    keyCount++;
                }
            }
        }
        int allKeys = (1 << keyCount) - 1;

        var visited = new HashSet<String>();
        var dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        var q = new LinkedList<int[]>();
        if (start == null) return -1;
        q.add(new int[]{start[0], start[1], 0});
        visited.add(0 + " " + start[0] + " " + start[1]);

        int res = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                var pop = q.pop();
                int i = pop[0], j = pop[1], keys = pop[2];
                if (keys == allKeys) return res;
                for (var d : dirs) {
                    int newi = i + d[0], newj = j + d[1], newkeys = keys;
                    if (newi >= 0 && newi < m && newj >= 0 && newj < n) {
                        char b = board[newi][newj];
                        if (b == '#') continue;
                        if (b >= 'A' && b <= 'F' && !containsKey(newkeys, b)) continue;
                        if (b >= 'a' && b <= 'f') {
                            newkeys = addKey(newkeys, b);
                        }

                        if (!visited.contains(keys + " " + newi + " " + newj)) {
                            visited.add(keys + " " + newi + " " + newj);
                            q.add(new int[]{newi, newj, newkeys});
                        }
                    }
                }
            }
            res++;
        }
        return -1;
    }

    private boolean containsKey(int keys, char k) {
        return (keys & (1 << (k - 'A'))) != 0;
    }

    private int addKey(int keys, char k) {
        return keys | (1 << (k - 'a'));
    }
}

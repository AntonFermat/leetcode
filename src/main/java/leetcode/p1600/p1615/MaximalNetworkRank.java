package leetcode.p1600.p1615;

import java.util.HashSet;

public class MaximalNetworkRank {
    public int maximalNetworkRank(int n, int[][] roads) {
        HashSet[] map = new HashSet[n];
        for (var r : roads) {
            if (map[r[0]] == null) map[r[0]] = new HashSet<Integer>();
            map[r[0]].add(r[1]);
            if (map[r[1]] == null) map[r[1]] = new HashSet<Integer>();
            map[r[1]].add(r[0]);
        }
        int res = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int counti = 0;
                if (map[i] != null) {
                    counti = map[i].contains(j) ? map[i].size() - 1 : map[i].size();
                }
                int countj = 0;
                if (map[j] != null) {
                    countj = map[j].size();
                }
                res = Math.max(res, counti + countj);
            }
        }
        return res;
    }
}

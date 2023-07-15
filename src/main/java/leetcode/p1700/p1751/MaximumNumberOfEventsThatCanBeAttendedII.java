package leetcode.p1700.p1751;

import java.util.*;

public class MaximumNumberOfEventsThatCanBeAttendedII {
    public int maxValue(int[][] events, int k) {
        int res = 0;
        int len = events.length;
        var memo = new int[len][k];
        var map = new TreeMap<Integer, Integer>();
        Arrays.sort(events, (e1, e2) -> e1[1] == e2[1] ? e1[0] - e2[0] : e1[1] - e2[1]);
        for (int i = 0; i < len; i++) {
            var e = events[i];
            int start = e[0];
            int finish = e[1];
            int val = e[2];

            var floor = map.floorEntry(start - 1);
            var prev = floor == null ? new int[k] : memo[floor.getValue()];
            for (int j = 0; j < k; j++) {
                memo[i][j] = Math.max((j == 0 ? 0 : prev[j - 1]) + val, prev[j]);
                res = Math.max(res, memo[i][j]);
            }
            map.put(finish, i);
        }
        return res;
    }
}

package leetcode.p1300.p1376;

import java.util.*;

public class TimeNeededToInformAllEmployees {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        var map = new HashMap<Integer, List<Integer>>();
        for (int i = 0; i < manager.length; i++) {
            if (i == headID) continue;
            map.computeIfAbsent(manager[i], m -> new ArrayList<>()).add(i);
        }
        return dfs(headID, map, informTime);
    }

    int dfs(int id, Map<Integer, List<Integer>> map, int[] informTime) {
        var children = map.get(id);
        if (children == null) return 0;
        int max = 0;
        for (Integer child : children) {
            max = Math.max(max, dfs(child, map, informTime));
        }
        return informTime[id] + max;
    }
}

package leetcode.p0200.p0207;

import java.util.*;

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        var degree = new int[numCourses];
        var map = new HashMap<Integer, Set<Integer>>();
        for (var p : prerequisites) {
            int start = p[0];
            int finish = p[1];
            map.computeIfAbsent(start, o -> new HashSet<>()).add(finish);
            degree[finish]++;
        }

        var q = new LinkedList<Integer>();
        for (int i = 0; i < numCourses; i++) {
            if (degree[i] == 0) q.add(i);
        }


        while (!q.isEmpty()) {
            int cur = q.poll();
            if (map.containsKey(cur)) {
                for (int next : map.get(cur)) {
                    if (--degree[next] == 0) q.add(next);
                }
            }
        }

        for (var d : degree) {
            if (d != 0) return false;
        }

        return true;
    }
}

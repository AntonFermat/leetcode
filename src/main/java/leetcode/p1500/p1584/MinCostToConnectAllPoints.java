package leetcode.p1500.p1584;

import java.util.*;

public class MinCostToConnectAllPoints {
    public int minCostConnectPoints(int[][] points) {
        int len = points.length;
        var visited = new boolean[len];
        int count = 0;
        int res = 0;
        var pq = new PriorityQueue<int[]>(Comparator.comparingInt(i -> i[0]));
        pq.add(new int[]{0, 0});
        while (count < len) {
            var cur = pq.poll();
            int dist = cur[0];
            int index = cur[1];
            if (visited[index]) continue;

            res += dist;
            visited[index] = true;
            count++;
            for (int i = 0; i < len; i++) {
                if (!visited[i]) {
                    int ndist = Math.abs(points[i][0] - points[index][0]) + Math.abs(points[i][1] - points[index][1]);
                    pq.add(new int[]{ndist, i});
                }
            }
        }
        return res;
    }
}

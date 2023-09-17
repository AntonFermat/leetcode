package leetcode.p0800.p0847;

import java.util.*;

public class ShortestPathVisitingAllNodes {
    public int shortestPathLength(int[][] graph) {
        int len = graph.length;
        var dp = new int[len][1 << len];
        var q = new LinkedList<int[]>();
        for (int i = 0; i < len; i++) {
            Arrays.fill(dp[i], -1);
            int visited = 1 << i;
            dp[i][visited] = 0;
            q.add(new int[]{i, visited});
        }

        int allVisited = (1 << len) - 1;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                var poll = q.poll();
                int cur = poll[0];
                int visited = poll[1];
                if (visited == allVisited) return dp[cur][visited];
                for (int next : graph[cur]) {
                    int nvisited = visited | (1 << next);
                    if (dp[next][nvisited] != -1) continue;
                    dp[next][nvisited] = dp[cur][visited] + 1;
                    q.add(new int[]{next, nvisited});
                }
            }
        }
        return -1;
    }
}

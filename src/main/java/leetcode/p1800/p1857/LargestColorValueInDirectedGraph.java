package leetcode.p1800.p1857;

import java.util.*;

public class LargestColorValueInDirectedGraph {

    public int largestPathValue(String colors, int[][] edges) {
        int n = colors.length();
        this.colors = colors;
        memo = new int[n][26];

        map = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            map.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            map.get(edge[0]).add(edge[1]);
        }

        int res = -1;
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            int count = dfs(i, new boolean[n]);
            res = Math.max(count, res);
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    private String colors;
    private List<List<Integer>> map;
    private int[][] memo;
    private boolean[] visited;

    private int dfs(int node, boolean[] v) {
        if (v[node]) {
            return Integer.MAX_VALUE;
        }
        int color = colors.charAt(node) - 'a';
        if (visited[node]) return memo[node][color];

        visited[node] = true;
        v[node] = true;
        for (int next : map.get(node)) {
            int data = dfs(next, v);
            if (data == Integer.MAX_VALUE) return Integer.MAX_VALUE;
            for (int i = 0; i < 26; i++) {
                memo[node][i] = Math.max(memo[node][i], memo[next][i]);
            }
        }
        memo[node][color]++;
        v[node] = false;
        return memo[node][color];
    }
}

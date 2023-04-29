package leetcode.p1600.p1697;

import java.util.*;

public class CheckingExistenceOfEdgeLengthLimitedPaths {
    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        int elen = edgeList.length;
        int qlen = queries.length;
        Arrays.sort(edgeList, Comparator.comparingInt(e -> e[2]));
        var res = new boolean[qlen];
        var uf = new UnionFind(n);
        var queries2 = new int[qlen][4];
        for (int i = 0; i < qlen; i++) {
            queries2[i] = new int[]{queries[i][0], queries[i][1], queries[i][2], i};
        }
        Arrays.sort(queries2, Comparator.comparingInt(q -> q[2]));
        int eindex = 0;
        for (var q : queries2) {
            int start = q[0], end = q[1], limit = q[2], qindex = q[3];
            while (eindex < elen && edgeList[eindex][2] < limit) {
                uf.union(edgeList[eindex][0], edgeList[eindex][1]);
                eindex++;
            }
            res[qindex] = uf.isConnected(start, end);
        }
        return res;
    }

    private static class UnionFind {
        private final int[] parents;
        private final int[] ranks;

        public UnionFind(int n) {
            parents = new int[n];
            for (int i = 0; i < n; i++) parents[i] = i;
            ranks = new int[n];
        }

        public int find(int x) {
            if (x != parents[x]) parents[x] = find(parents[x]);
            return parents[x];
        }

        public void union(int x1, int x2) {
            int fx1 = find(x1);
            int fx2 = find(x2);
            if (fx1 != fx2) {
                if (ranks[fx1] < ranks[fx2]) parents[fx1] = fx2;
                else if (ranks[fx1] > ranks[fx2]) parents[fx2] = fx1;
                else {
                    parents[fx1] = fx2;
                    ranks[fx2]++;
                }
            }
        }

        public boolean isConnected(int x1, int x2) {
            int fx1 = find(x1);
            int fx2 = find(x2);
            return fx1 == fx2;
        }
    }
}

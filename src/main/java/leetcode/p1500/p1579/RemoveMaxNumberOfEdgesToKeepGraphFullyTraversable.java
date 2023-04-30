package leetcode.p1500.p1579;

import java.util.*;

public class RemoveMaxNumberOfEdgesToKeepGraphFullyTraversable {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        var uf1 = new UnionFind(n);
        var uf2 = new UnionFind(n);
        int res = 0;
        Arrays.sort(edges, (e1, e2) -> e2[0] - e1[0]);
        for (var e : edges) {
            int type = e[0];
            int node1 = e[1];
            int node2 = e[2];
            if (type == 1) {
                if (!uf1.union(node1, node2)) res++;
            } else if (type == 2) {
                if (!uf2.union(node1, node2)) res++;
            } else {
                boolean b1 = uf1.union(node1, node2);
                boolean b2 = uf2.union(node1, node2);
                if (!b1 && !b2) res++;
            }
        }

        return (uf1.isConnected() && uf2.isConnected()) ? res : -1;
    }

    private static class UnionFind {
        int[] parents;
        int[] ranks;

        public UnionFind(int size) {
            parents = new int[size + 1];
            for (int i = 0; i <= size; i++) parents[i] = i;
            ranks = new int[size + 1];
        }

        public int find(int x) {
            if (parents[x] != x) parents[x] = find(parents[x]);
            return parents[x];
        }

        public boolean union(int x1, int x2) {
            int fx1 = find(x1), fx2 = find(x2);
            if (fx1 == fx2) return false;
            else {
                if (ranks[fx1] < ranks[fx2]) {
                    parents[fx2] = parents[fx1];
                } else if (ranks[fx1] > ranks[fx2]) {
                    parents[fx1] = parents[fx2];
                } else {
                    parents[fx2] = parents[fx1];
                    ranks[fx1]++;
                }
            }
            return true;
        }

        public boolean isConnected() {
            int par0 = find(1);
            for (int i = 1; i < parents.length; i++) {
                if (find(i) != par0) return false;
            }
            return true;
        }
    }
}

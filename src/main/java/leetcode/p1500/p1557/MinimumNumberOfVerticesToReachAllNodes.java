package leetcode.p1500.p1557;

import java.util.*;
import java.util.stream.Collectors;

public class MinimumNumberOfVerticesToReachAllNodes {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        var res = new HashSet<Integer>();
        for (int i = 0; i < n; i++) res.add(i);
        for (var edge : edges) {
            res.remove(edge.get(1));
        }

        return new ArrayList<>(res);
    }
}

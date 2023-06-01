package leetcode.p0300.p0399;

import java.util.*;

public class EvaluateDivision {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int len = values.length;
        for (int i = 0; i < len; i++) {
            var eq0 = equations.get(i).get(0);
            var eq1 = equations.get(i).get(1);
            map.computeIfAbsent(eq0, o -> new HashSet<>()).add(eq1);
            map.computeIfAbsent(eq1, o -> new HashSet<>()).add(eq0);

            mapv.put(new Pair<>(eq0, eq1), values[i]);
            mapv.put(new Pair<>(eq1, eq0), 1 / values[i]);
        }

        var res = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            res[i] = bfs(queries.get(i));
        }
        return res;
    }

    Map<String, Set<String>> map = new HashMap<>();
    Map<Pair<String, String>, Double> mapv = new HashMap<>();

    double bfs(List<String> query) {
        String start = query.get(0), finish = query.get(1);
        if (start.equals(finish) && map.containsKey(start)) return 1.0;

        var q = new LinkedList<Pair<String, Double>>();
        q.add(new Pair<>(start, 1.0));
        var visited = new HashSet<String>();
        visited.add(start);

        while (!q.isEmpty()) {
            var poll = q.poll();
            var cur = poll.getKey();
            var val = poll.getValue();
            if (map.containsKey(cur)) {
                for (var next : map.get(cur)) {
                    if (!visited.contains(next) && mapv.containsKey(new Pair<>(cur, next))) {
                        var nextVal = val * mapv.get(new Pair<>(cur, next));
                        if (next.equals(finish)) return nextVal;

                        q.add(new Pair<>(next, nextVal));
                        visited.add(next);
                    }
                }
            }
        }
        return -1;
    }

    private static class Pair<E, P> {
        final private E key;
        final private P value;

        public Pair(E key, P value) {
            this.key = key;
            this.value = value;
        }

        public E getKey() {
            return key;
        }

        public P getValue() {
            return value;
        }
    }
}

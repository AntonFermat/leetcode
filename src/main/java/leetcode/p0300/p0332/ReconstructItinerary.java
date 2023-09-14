package leetcode.p0300.p0332;

import java.util.*;

public class ReconstructItinerary {
    public List<String> findItinerary(List<List<String>> tickets) {
        var map = new HashMap<String, List<String>>();
        for (var ticket : tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);
            map.computeIfAbsent(from, o -> new ArrayList<>()).add(to);
        }

        for (var e : map.entrySet()) {
            var from = e.getKey();
            var to = e.getValue();
            Collections.sort(to);
            vmap.put(from, new boolean[to.size()]);
        }
        var cur = new ArrayList<>(List.of("JFK"));
        dfs(tickets.size() + 1, map, cur, "JFK");
        return res;
    }

    private List<String> res = new ArrayList<>();
    private final Map<String, boolean[]> vmap = new HashMap<>();

    private boolean dfs(int size, Map<String, List<String>> map, List<String> cur, String from) {
        if (cur.size() == size) {
            res = new ArrayList<>(cur);
            return true;
        }
        if (map.containsKey(from)) {
            var dest = map.get(from);
            var v = vmap.get(from);
            for (int i = 0; i < dest.size(); i++) {
                if (v[i]) continue;
                String to = dest.get(i);
                cur.add(to);
                v[i] = true;
                boolean res = dfs(size, map, cur, to);
                cur.remove(cur.size() - 1);
                v[i] = false;
                if (res) return true;
            }
        }
        return false;
    }
}

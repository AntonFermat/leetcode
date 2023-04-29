package leetcode.p0800.p0839;

import java.util.*;

public class SimilarStringGroups {
    public int numSimilarGroups(String[] strs) {
        int len = strs.length;
        var map = new HashMap<Integer, Set<Integer>>();
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (similar(strs[i], strs[j])) {
                    map.computeIfAbsent(i, o -> new HashSet<>()).add(j);
                    map.computeIfAbsent(j, o -> new HashSet<>()).add(i);
                }
            }
        }
        int res = 0;
        var visited = new HashSet<Integer>();
        for (int i = 0; i < len; i++) {
            if (visited.contains(i)) continue;
            res++;
            var q = new LinkedList<Integer>();
            q.add(i);
            visited.add(i);
            while (!q.isEmpty()) {
                int cur = q.poll();
                if (map.containsKey(cur)) {
                    for (var next : map.get(cur)) {
                        if (visited.contains(next)) continue;
                        q.add(next);
                        visited.add(next);
                    }
                }
            }
        }
        return res;
    }

    private boolean similar(String str1, String str2) {
        int res = 0;
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) res++;
            if (res > 2) return false;
        }
        return true;
    }
}

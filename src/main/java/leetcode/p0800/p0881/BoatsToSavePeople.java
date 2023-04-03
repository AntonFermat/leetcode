package leetcode.p0800.p0881;

import java.util.TreeMap;

public class BoatsToSavePeople {
    public int numRescueBoats(int[] people, int limit) {
        var treeMap = new TreeMap<Integer, Integer>();
        for (var p : people) treeMap.put(p, treeMap.getOrDefault(p, 0) + 1);

        int res = 0;
        while (!treeMap.isEmpty()) {
            res++;
            var first = treeMap.firstEntry();
            if (first.getValue() > 1) treeMap.put(first.getKey(), first.getValue() - 1);
            else treeMap.remove(first.getKey());

            var second = treeMap.floorEntry(limit - first.getKey());
            if (second != null) {
                if (second.getValue() > 1) treeMap.put(second.getKey(), second.getValue() - 1);
                else treeMap.remove(second.getKey());
            }
        }
        return res;
    }
}
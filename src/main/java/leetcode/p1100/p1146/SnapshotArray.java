package leetcode.p1100.p1146;

import java.util.*;

public class SnapshotArray {
    private final Map<Integer, TreeMap<Integer, Integer>> map = new HashMap<>();
    private int snap = 0;

    public SnapshotArray(int length) {
    }

    public void set(int index, int val) {
        map.computeIfAbsent(index, o -> new TreeMap<>()).put(snap, val);
    }

    public int snap() {
        return snap++;
    }

    public int get(int index, int snap_id) {
        if (map.containsKey(index)) {
            var e = map.get(index).floorEntry(snap_id);
            return e == null ? 0 : e.getValue();
        }
        return 0;
    }
}

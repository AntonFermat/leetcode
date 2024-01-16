package leetcode.p0300.p0380;

import java.util.*;

public class RandomizedSet {
    private final List<Integer> arr;
    private final Map<Integer, Integer> map;
    private final Random rand;

    public RandomizedSet() {
        arr = new ArrayList<>();
        map = new HashMap<>();
        rand = new Random();
    }

    public boolean insert(int val) {
        if (map.containsKey(val)) return false;

        int size = arr.size();
        arr.add(val);
        map.put(val, size);
        return true;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;
        int indexDel = map.get(val);
        map.remove(val);

        int lastIndex = arr.size() - 1;
        int last = arr.get(lastIndex);

        arr.remove(lastIndex);
        if (indexDel != lastIndex) {
            arr.set(indexDel, last);
            map.put(last, indexDel);
        }
        return true;
    }

    public int getRandom() {
        return arr.get(rand.nextInt(arr.size()));
    }
}
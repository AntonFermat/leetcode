package leetcode.p0700.p0706;

import java.util.Arrays;

public class MyHashMap {
    int[] map = new int[1_000_001];

    public MyHashMap() {
        Arrays.fill(map, -1);
    }

    public void put(int key, int value) {
        map[key] = value;
    }

    public int get(int key) {
        return map[key];
    }

    public void remove(int key) {
        map[key] = -1;
    }
}

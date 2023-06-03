package leetcode.p0700.p0705;

public class MyHashSet {

    public MyHashSet() {
    }

    private final boolean[] arr = new boolean[1_000_001];

    public void add(int key) {
        arr[key] = true;
    }

    public void remove(int key) {
        arr[key] = false;
    }

    public boolean contains(int key) {
        return arr[key];
    }
}

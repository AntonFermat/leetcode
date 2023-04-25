package leetcode.p2300.p2336;

import java.util.PriorityQueue;

public class SmallestInfiniteSet {
    final private PriorityQueue<Integer> pq = new PriorityQueue<>();
    private int count = 1;

    public SmallestInfiniteSet() {
    }

    public int popSmallest() {
        if (pq.isEmpty()) return count++;
        return pq.poll();
    }

    public void addBack(int num) {
        if (num < count && !pq.contains(num)) pq.add(num);
    }
}
package leetcode.p1000.p1046;

import java.util.PriorityQueue;

public class LastStoneWeight {
    public int lastStoneWeight(int[] stones) {
        var pq = new PriorityQueue<Integer>((s1, s2) -> s2 - s1);
        for (int s : stones) pq.add(s);
        while (pq.size() > 1) pq.add(pq.poll() - pq.poll());
        return pq.poll();
    }
}

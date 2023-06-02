package leetcode.p0700.p0703;

import java.util.PriorityQueue;

public class KthLargest {
    private final PriorityQueue<Integer> q = new PriorityQueue<>();
    private final int k;

    public KthLargest(int k, int[] nums) {
        for (int num : nums) {
            q.add(num);
            if (q.size() > k) q.poll();
        }
        this.k = k;
    }

    public int add(int val) {
        q.add(val);
        if (q.size() > k) q.poll();
        return q.peek();
    }
}

package leetcode.p0200.p0215;

import java.util.PriorityQueue;

public class KthLargestElementInAnArray {
    public int findKthLargest(int[] nums, int k) {
        var pq = new PriorityQueue<Integer>();
        for (int num : nums) {
            pq.add(num);
            if (pq.size() > k) pq.poll();
        }

        return pq.peek();
    }
}

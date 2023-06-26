package leetcode.p2400.p2462;

import java.util.*;

public class TotalCostToHireKWorkers {
    public long totalCost(int[] costs, int k, int candidates) {
        int len = costs.length;
        long res = 0;

        var list = new LinkedList<Integer>();
        for (int c : costs) list.add(c);

        var pq1 = new PriorityQueue<Integer>();
        var pq2 = new PriorityQueue<Integer>();

        for (int i = 0; i < candidates; i++) pq1.add(list.pollFirst());
        for (int i = 0; i < candidates; i++) {
            if (!list.isEmpty()) pq2.add(list.pollLast());
        }

        for (int i = 0; i < k; i++) {
            if (!pq2.isEmpty() && (pq1.isEmpty() || pq1.peek() > pq2.peek())) {
                res += pq2.poll();
                if (!list.isEmpty()) pq2.add(list.pollLast());
            } else if (!pq1.isEmpty() && (pq2.isEmpty() || pq1.peek() <= pq2.peek())) {
                res += pq1.poll();
                if (!list.isEmpty()) pq1.add(list.pollFirst());
            }
        }

        return res;
    }
}

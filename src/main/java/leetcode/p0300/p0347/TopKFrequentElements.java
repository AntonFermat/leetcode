package leetcode.p0300.p0347;

import java.util.*;

public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        var map = new HashMap<Integer, Integer>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        var pq = new PriorityQueue<Map.Entry<Integer, Integer>>((e1, e2) -> e2.getValue() - e1.getValue());
        pq.addAll(map.entrySet());

        var res = new int[k];
        for (int i = 0; i < k; i++) {
            if (!pq.isEmpty()) res[i] = pq.poll().getKey();
        }
        return res;
    }
}

package leetcode.p1900.p1921;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

public class Solution {
    public int eliminateMaximum(int[] dist, int[] speed) {
        var pq = new PriorityQueue<Integer>();
        for (int i = 0; i < dist.length; i++) pq.add((dist[i] + speed[i] - 1) / speed[i]);
        int res = 0;
        while (!pq.isEmpty() && pq.poll() > res) res++;
        return res;
    }
}

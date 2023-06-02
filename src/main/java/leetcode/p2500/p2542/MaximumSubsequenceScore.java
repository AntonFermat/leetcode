package leetcode.p2500.p2542;

import java.util.*;

public class MaximumSubsequenceScore {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int len = nums1.length;
        var nn = new int[len][2];
        for (int i = 0; i < len; i++) {
            nn[i][0] = nums1[i];
            nn[i][1] = nums2[i];
        }

        Arrays.sort(nn, (p1, p2) -> p2[1] - p1[1]);
        var pq = new PriorityQueue<int[]>(Comparator.comparingInt(p -> p[0]));
        long res = 0, sum = 0;
        for (int i = 0; i < len; i++) {
            int n1 = nn[i][0], n2 = nn[i][1];
            pq.add(nn[i]);
            sum += n1;
            if (pq.size() == k) {
                res = Math.max(res, n2 * sum);
                if (!pq.isEmpty()) sum -= pq.poll()[0];
            }
        }

        return res;
    }
}

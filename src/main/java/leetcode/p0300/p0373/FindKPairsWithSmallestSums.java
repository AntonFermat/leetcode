package leetcode.p0300.p0373;

import java.util.*;

public class FindKPairsWithSmallestSums {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        var res = new ArrayList<List<Integer>>();
        int len1 = nums1.length, len2 = nums2.length;

        var pq = new PriorityQueue<int[]>(Comparator.comparingInt(i -> (nums1[i[0]] + nums2[i[1]])));
        pq.add(new int[]{0, 0});
        var v = new HashSet<Pair>();

        while (k-- > 0 && !pq.isEmpty()) {
            int i = pq.peek()[0];
            int j = pq.poll()[1];
            res.add(List.of(nums1[i], nums2[j]));

            if (i + 1 < len1 && !v.contains(new Pair(i + 1, j))) {
                pq.add(new int[]{i + 1, j});
                v.add(new Pair(i + 1, j));
            }
            if (j + 1 < len2 && !v.contains(new Pair(i, j + 1))) {
                pq.add(new int[]{i, j + 1});
                v.add(new Pair(i, j + 1));
            }
        }
        return res;
    }

    private record Pair(int key, int value) {
    }
}

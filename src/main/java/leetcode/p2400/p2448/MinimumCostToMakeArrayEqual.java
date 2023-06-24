package leetcode.p2400.p2448;

import java.util.Arrays;
import java.util.Comparator;

public class MinimumCostToMakeArrayEqual {
    public long minCost(int[] nums, int[] cost) {
        int len = nums.length;
        int l = Integer.MAX_VALUE, r = Integer.MIN_VALUE;
        var arr = new int[len][2];
        for (int i = 0; i < len; i++) {
            arr[i][0] = nums[i];
            arr[i][1] = cost[i];
            l = Math.min(l, nums[i]);
            r = Math.max(r, nums[i]);
        }
        if (l == r) return 0;
        Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));

        while (l < r) {
            int m = l + (r - l) / 2;
            long cost1 = cost(arr, m);
            long cost2 = cost(arr, m + 1);
            if (cost1 > cost2) {
                l = m + 1;
            } else r = m;
        }

        return Math.min(cost(arr, l), cost(arr, l + 1));
    }

    private long cost(int[][] arr, int m) {
        int len = arr.length;
        long res = 0;
        for (var a : arr) {
            res += (long) Math.abs(a[0] - m) * a[1];
        }
        return res;
    }
}

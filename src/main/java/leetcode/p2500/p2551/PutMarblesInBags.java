package leetcode.p2500.p2551;

import java.util.Arrays;

public class PutMarblesInBags {
    public long putMarbles(int[] weights, int k) {
        int len = weights.length;
        if (k > len - 1) return 0;
        var arr = new long[len - 1];
        for (int i = 0; i < len - 1; i++) {
            arr[i] = weights[i] + weights[i + 1];
        }

        Arrays.sort(arr);
        long res = 0;
        for (int i = 0; i < k - 1; i++) {
            res += (arr[len - 2 - i] - arr[i]);
        }
        return res;
    }
}

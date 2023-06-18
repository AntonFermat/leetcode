package leetcode.p1500.p1569;

import java.util.*;

public class NumberOfWaysToReorderArrayToGetSameBST {
    public int numOfWays(int[] nums) {
        var list = new ArrayList<Integer>();
        for (int num : nums) list.add(num);
        return (int) helper(list) - 1;
    }

    private long helper(List<Integer> list) {
        int len = list.size();
        if (len < 3) return 1;

        var left = new ArrayList<Integer>();
        var right = new ArrayList<Integer>();
        int root = list.get(0);
        for (int i = 1; i < len; i++) {
            int num = list.get(i);
            if (root > num) left.add(num);
            else right.add(num);
        }
        return ((helper(left) * helper(right) % mod) * c[len - 1][left.size()]) % mod;
    }

    private static final int mod = 1_000_000_007;
    private static final long[][] c = new long[1001][1001];

    static {
        for (int i = 0; i < 1001; i++) {
            c[i][0] = 1;
            c[i][i] = 1;
        }
        for (int i = 2; i < 1001; i++) {
            for (int j = 1; j < i; j++) {
                c[i][j] = (c[i - 1][j - 1] + c[i - 1][j]) % mod;
            }
        }
    }
}

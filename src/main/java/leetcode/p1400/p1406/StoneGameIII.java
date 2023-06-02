package leetcode.p1400.p1406;

import java.util.Arrays;

public class StoneGameIII {
    public String stoneGameIII(int[] stoneValue) {
        sv = stoneValue;
        memo = new int[sv.length];
        Arrays.fill(memo, Integer.MIN_VALUE);
        var x = helper(0);
        System.out.println(x);
        if (x > 0) return "Alice";
        else if (x < 0) return "Bob";
        return "Tie";
    }

    private int[] sv;
    private int[] memo;

    private int helper(int index) {
        int len = sv.length;
        if (index >= len) return 0;

        if (memo[index] != Integer.MIN_VALUE) return memo[index];

        int res = sv[index] - helper(index + 1);
        int pts = 0;
        for (int i = 0; i < 3; i++) {
            if (index + i >= len) continue;
            pts += sv[index + i];
            res = Math.max(res, pts - helper(index + i + 1));
        }
        return memo[index] = res;
    }
}

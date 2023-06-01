package leetcode.p1700.p1799;

import java.util.Arrays;

public class MaximizeScoreAfterNOperations {
    public int maxScore(int[] nums) {
        this.nums = nums;
        this.memo = new int[1 << nums.length];
        Arrays.fill(memo, -1);
        return backtrack(0, 0);
    }

    private int[] nums;
    private int[] memo;
    private final int res = 0;

    private int backtrack(int oper, int visited) {
        int len = nums.length;
        if (oper * 2 == len) return 0;
        if (memo[visited] != -1) return memo[visited];
        int res = 0;
        for (int i = 0; i < len; i++) {
            if ((visited & (1 << i)) != 0) continue;
            for (int j = i + 1; j < len; j++) {
                if (i == j || (visited & (1 << j)) != 0) continue;
                int v = visited | (1 << i) | (1 << j);
                res = Math.max(res, (oper + 1) * gcd(nums[i], nums[j]) + backtrack(oper + 1, v));
            }
        }

        return memo[visited] = res;
    }

    private int gcd(int a, int b) {
        while (a % b > 0) {
            int x = a % b;
            a = b;
            b = x;
        }
        return b;
    }
}

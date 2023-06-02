package leetcode.p1100.p1140;

public class StoneGameII {
    private int[] prefix;
    private int[][] memo;

    public int stoneGameII(int[] piles) {
        int len = piles.length;
        prefix = new int[len];
        prefix[len - 1] = piles[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            prefix[i] = prefix[i + 1] + piles[i];
        }
        memo = new int[len][len];
        return helper(piles, 0, 1);
    }

    private int helper(int[] piles, int index, int m) {
        int len = piles.length;
        if (index == len) return 0;
        if (2 * m >= len - index) {
            return prefix[index];
        }
        if (memo[index][m] != 0) return memo[index][m];
        int min = Integer.MAX_VALUE;
        for (int x = 1; x <= 2 * m; x++) {
            min = Math.min(min, helper(piles, index + x, Math.max(m, x)));
        }
        memo[index][m] = prefix[index] - min;
        return memo[index][m];
    }
}

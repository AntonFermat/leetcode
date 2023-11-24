package leetcode.p1500.p1561;

import java.util.Arrays;

public class Solution {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int res = 0;
        for (int i = 0; i < piles.length / 3; i ++) {
            res += piles[piles.length - 2 - 2 * i];
        }
        return res;
    }
}

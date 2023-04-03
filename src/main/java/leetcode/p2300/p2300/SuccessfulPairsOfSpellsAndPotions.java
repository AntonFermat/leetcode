package leetcode.p2300.p2300;

import java.util.Arrays;

public class SuccessfulPairsOfSpellsAndPotions {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n = spells.length, m = potions.length;
        var res = new int[n];

        Arrays.sort(potions);
        for (int i = 0; i < n; i++) {
            int spell = spells[i];

            long potion = success / spell + (success % spell == 0 ? 0L : 1L);

            int left = 0, right = m;
            while (left < right) {
                int mid = left + (right - left) / 2;

                if (potions[mid] < potion) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            res[i] = m - right;
        }
        return res;
    }
}

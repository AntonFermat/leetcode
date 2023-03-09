package leetcode.p0800.p0875;

public class KokoEatingBananas {
    public int minEatingSpeed(int[] piles, int h) {
        int len = piles.length;
        int l = 1, r = piles[0];
        for (int pile : piles) r = Math.max(r, pile);
        while (l < r) {
            int m = l + (r - l) / 2;
            boolean isPossible = true;
            int cur = 0;
            for (int pile : piles) {
                cur += pile % m == 0 ? pile / m : (pile / m) + 1;
                if (cur > h) {
                    isPossible = false;
                    break;
                }
            }
            if (isPossible) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return r;
    }
}

package leetcode.p2700.p2706;

public class Solution {
    public int buyChoco(int[] prices, int money) {
        int p1 = 100, p2 = 100;
        for (int p : prices) {
            if (p < p1) {
                p2 = p1;
                p1 = p;
            } else p2 = Math.min(p, p2);
        }
        if (money - p1 - p2 < 0) return money;
        return money - p1 - p2;
    }
}

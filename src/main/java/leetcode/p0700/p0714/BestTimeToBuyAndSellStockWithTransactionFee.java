package leetcode.p0700.p0714;

public class BestTimeToBuyAndSellStockWithTransactionFee {
    public int maxProfit(int[] prices, int fee) {
        int res = 0, diff = -prices[0];
        for (int p : prices) {
            res = Math.max(res, diff + p - fee);
            diff = Math.max(diff, res - p);
        }
        return res;
    }
}

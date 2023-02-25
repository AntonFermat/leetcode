package leetcode.p0100.p0121;

public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int res = 0, min = Integer.MAX_VALUE;
        for (int price : prices) {
            if(price < min) min = price;
            if(res < price - min) res = price - min;
        }
        return res;
    }
}

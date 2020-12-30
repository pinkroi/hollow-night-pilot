package leetcode;

public class Stock {
    /**
     * 买卖一次
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int profit = 0;
        int minPrice = Integer.MAX_VALUE;
        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            }
            profit = Math.max(profit, price - minPrice);
        }
        return profit;
    }

    /**
     * 买卖多次
     *
     * @param prices
     * @return
     */
    public int maxProfits(int[] prices) {
        int profit = 0;
        // O(n-1)
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i + 1] > prices[i]) {
                profit += prices[i + 1] - prices[i];
            }
        }
        return profit;
    }
}

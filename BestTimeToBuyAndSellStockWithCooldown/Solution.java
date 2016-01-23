public class Solution {
    public int maxProfit(int[] prices) {
        int sell = 0, wait = 0;
        for(int i = 1, copy = sell; i < prices.length; ++i, copy = sell) {
            sell = Math.max(sell + prices[i] - prices[i - 1], wait);
            wait = Math.max(copy, wait);
        }
        return Math.max(sell, wait);
    }
}

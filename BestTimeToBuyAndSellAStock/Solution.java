public class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length <= 1) {
            return 0;
        }
        int min = prices[0], max = prices[0], best = 0;
        for(int i = 1, current = 0; i < prices.length; ++i) {
            if(prices[i] > max) {
                max = prices[i];
            } else if(prices[i] < min) {
                current = max - min;
                min = prices[i];
                max = prices[i];
                if(current > best) {
                    best = current;
                }
            }
        }
        return (best > (max - min)) ? best : (max - min);
    }
}

package com.wm.LeeCode.LeeCode.array;

public class LeeCode146 {
    public int maxProfit(int[] prices) {
        /*int len = prices.length;
        if (len < 2) {
            return 0;
        }
        int maxProfit = 0;
        for (int i = 0; i < len - 1; ++i) {
            for (int j = i + 1; j < len; ++j) {
                maxProfit = Math.max(maxProfit, prices[j] - prices[i]);
            }
        }
        return maxProfit;*/
        int len = prices.length;
        if (len < 2) {
            return 0;
        }
        int minProfit = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < len; ++i) {
            minProfit = Math.min(prices[i], minProfit);
            maxProfit = Math.max(prices[i] - minProfit, maxProfit);
        }
        return maxProfit;
    }
}

package com.wm.LeeCode.LeeCode.greedy.simple;

/**
 * @author wm
 * @Package com.wm.LeeCode.LeeCode.greedy.simple
 * @date 2020/11/16 15:47
 */
public class LeeCode122 {

    public int maxProfit(int[] prices) {
        /*if (prices.length == 0){
            return 0;
        }
        int mono = prices[0];
        int sum = 0;
        int temp = 0;
        for (int i = 1; i < prices.length; i++){
            if (prices[i] > mono){
                if (prices[i]>prices[i-1]){
                    temp = prices[i] - mono;
                }
            }else if (prices[i] < mono){
                sum += temp;
                mono = prices[i];
            }
        }
        return sum;*/
/*
        int len = prices.length;

        if (len < 2){
            return 0;
        }

        int[][] dp = new int[len][2];

        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        for (int i = 1; i < len; i++){
            dp[i][0] = Math.max(dp[i - 1][0],dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1],dp[i - 1][0] - prices[i]);
        }
        return dp[len - 1][0];
      */
        /*
        int len = prices.length;
        if (len < 2){
            return 0;
        }

        int cash = 0;
        int hold = -prices[0];

        int preCash = cash;
        int preHold = hold;

        for (int i = 1; i < len; i++){
            cash = Math.max(preCash, preHold + prices[i]);
            hold = Math.max(preHold, preCash - prices[i]);

            preCash = cash;
            preHold = hold;
        }
        return cash;

        */

        int len = prices.length;
        if (len < 2){
            return 0;
        }

        int res = 0;
        for (int i = 1; i < len; i++){
            /*int diff = prices[i] - prices[i - 1];
            if (diff > 0){
                res += diff;
            }*/
            res += Math.max(prices[i] - prices[i - 1],0);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println(new LeeCode122().maxProfit(prices));
    }
}

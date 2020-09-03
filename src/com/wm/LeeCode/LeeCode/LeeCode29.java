package com.wm.leecode.LeeCode;

/**
 * @author wm
 * @Package com.wm.leecode.LeeCode
 * @date 2020/8/31 9:07
 */
public class LeeCode29 {
    public int divide(int dividend,int divisor){
        int ans = -1;
        int sign = 1;
        if (dividend > 0){
            sign = opposite(sign);
            dividend = opposite(dividend);
        }
        if (divisor > 0){
            sign = opposite(sign);
            divisor = opposite(divisor);
        }

        int origin_dividend = dividend ;
        int origin_divisor = divisor;
        if (dividend > divisor){
            return 0;
        }
        dividend -= divisor;
        while (divisor >= dividend){
            ans = ans + ans;
            divisor += divisor;
            dividend -= divisor;
        }
        int a = ans + opposite(divide(origin_dividend - divisor,origin_divisor));
        if (a == Integer.MIN_VALUE){
            if (sign > 0){
                return Integer.MAX_VALUE;
            }else {
                return Integer.MIN_VALUE;
            }
        }else {
            if (sign > 0){
                return opposite(a);
            }else {
                return a;
            }
        }
    }

    private int opposite(int x) {
        return ~x + 1;
    }
}

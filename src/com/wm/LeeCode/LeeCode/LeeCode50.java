package com.wm.LeeCode.LeeCode;

/**
 * @author wm
 * @Package com.wm.LeeCode.LeeCode
 * @date 2021/1/29 10:28
 */
public class LeeCode50 {
    public double myPow(double x, int n) {
        /*double  rest = Math.pow(x, n);
        return rest;*/

        if (n == 0) return 1;
        if (n == 1) return x;
        double result = 1;
        long N = n;
        if (N < 0) {
            x = 1/x;
            N = -N;
        }
        while (N > 0) {
            if ((N & 1) == 1) {
                result *= x;
            }
            x *= x;
            N >>= 1;
        }
        return result;
    }

    public static void main(String[] args) {
        double x = 2.00000;
        int n = -2;
        System.out.println(new LeeCode50().myPow(x, n));
    }
}

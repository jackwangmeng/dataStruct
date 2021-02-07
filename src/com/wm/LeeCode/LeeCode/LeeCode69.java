package com.wm.LeeCode.LeeCode;

/**
 * @author wm
 * @Package com.wm.LeeCode.LeeCode
 * @date 2021/2/7 9:28
 */
public class LeeCode69 {
    public int mySqrt(int x) {
        /*if (x == 0) {
            return 0;
        }

        int result = (int) Math.exp(0.5 * Math.log(x));
        return (long)(result + 1) * (result + 1) <= x ? (result + 1) : result;*/
/*
        int left = 0, right = x, ans = -1;
        while (left <= x) {
            int mid = (left + right) >> 1;
            if (mid * mid <= x) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;*/
        if (x == 0) {
            return 0;
        }
        double C = x, x0 = x;
        while (true) {
            double xi = (x0 + C/x0) * 0.5;
            if (Math.abs(x0 - xi) < 1e-7) {
                break;
            }
            x0 = xi;
        }
        return (int)x0;
    }
}

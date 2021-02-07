package com.wm.LeeCode.LeeCode;

/**
 * @author wm
 * @Package com.wm.LeeCode.LeeCode
 * @date 2021/2/7 10:16
 */
public class LeeCode70 {
    int[][] dirs = {{1,1}, {1,0}};
    public int climbStairs(int n) {
        /*
        if(n <= 2) {
            return n;
        }
        int n1 = 1, n2 = 2;
        int temp;
        for (int i = 3; i <= n; ++i) {
            temp = n1;
            n1 = n2;
            n2 = temp + n2;
        }
        return n2;
        */
        /*if (n <= 2) {
            return n;
        }
        int[] climbStairs = new int[n];
        climbStairs[0] = 1;
        climbStairs[1] = 2;
        for (int i = 2; i < n; ++i) {
            climbStairs[i] = climbStairs[i - 1] + climbStairs[i - 2];
        }
        return climbStairs[n - 1];*/

        double sqrt5 = Math.sqrt(5);
        double fib = Math.pow((1 + sqrt5)/2, n + 1) - Math.pow((1 - sqrt5)/2, n + 1);
        return (int) Math.round(fib/sqrt5);

    }

}

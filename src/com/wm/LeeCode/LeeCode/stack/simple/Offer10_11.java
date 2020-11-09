package com.wm.LeeCode.LeeCode.stack.simple;

import java.util.Arrays;

/**
 * @author wm
 * @Package com.wm.LeeCode.LeeCode.stack.simple
 * @date 2020/11/9 9:51
 */
public class Offer10_11 {

    private int[] memo;

    public int numWays(int n) {
        /*int a = 1, b = 1, sum;
        for (int i = 0; i < n; i++){
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return a;*/
        memo = new int[n + 1];
        Arrays.fill(memo,-1);
        return jump(n);
    }

    private int jump(int n) {
        if (memo[n] != -1){
            return 1;
        }

        int pre = 1, cur = 2;
        for (int i = 3; i <= n; i++){
            int temp = (pre + cur) % 1000000007;
            pre = cur;
            cur = temp;
        }
        return cur;
    }

    public static void main(String[] args) {
        System.out.println(new Offer10_11().numWays(1));
    }
}

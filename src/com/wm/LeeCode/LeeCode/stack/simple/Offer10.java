package com.wm.LeeCode.LeeCode.stack.simple;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

/**
 * @author wm
 * @Package com.wm.LeeCode.LeeCode.stack.simple
 * @date 2020/11/9 9:35
 */
public class Offer10 {
    public int fib(int n) {
        if (n <= 1)
            return n;
        int num1 = 0, num2 = 1, sum = 0;
        while (n > 1){
            //sum = (num1 +num2) % 1000000007;
            sum = num1 + num2;
            if (sum > 1000000007){
                sum -= 1000000007;
            }
            num1 = num2;
            num2 = sum;
            n--;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new Offer10().fib(10));
    }
}

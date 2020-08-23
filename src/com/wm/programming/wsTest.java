package com.wm.programming;

public class wsTest {
    /*一个数如果恰好等于它的因子之和, 这个数就称为”完数”.
    例如 6 = 1+2+3。编程找出
1000 以内的所有完数。*/
    public static void main(String[] args) {
        for (int i = 2; i < 1000; i++){
            int s = 0;
            for (int j = 1; j < i; j++){
                if ((i % j) == 0){
                    s += i;
                }
            }
            if (s == i){
                System.out.print(i + "its factors are:");
                for (int j = 1; j < i; j++){
                    if ((i % j) == 0){
                        System.out.print(j);
                        System.out.print(" ");
                    }
                }
                System.out.println();
            }
        }
    }
}

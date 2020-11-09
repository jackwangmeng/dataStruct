package com.wm.LeeCode.LeeCode.stack.simple;

/**
 * @author wm
 * @Package com.wm.LeeCode.LeeCode.stack.simple
 * @date 2020/11/9 10:54
 */
public class Offer11 {
    public int minArray(int[] numbers) {
        int i = 0, j = numbers.length - 1;

        while (i < j){
            int m = (i + j) >> 1;
            if (numbers[m] > numbers[j])
                i = m + 1;
            else if(numbers[m] < numbers[j]){
                j = m;
            }else
                j--;
        }
        return numbers[i];
    }

    public static void main(String[] args) {
        int[] numbers = {1,3,5};
        System.out.println(new Offer11().minArray(numbers));
    }
}

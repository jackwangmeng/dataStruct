package com.wm.LeeCode.LeeCode.array;

/**
 * @author wm
 * @Package com.wm.LeeCode.LeeCode.array
 * @date 2021/1/18 10:24
 */
public class LeeCode66 {
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0) {
                return digits;
            }
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }

    public static void main(String[] args) {
        int[] digits = {1, 2, 3};
        System.out.println(new LeeCode66().plusOne(digits));
    }
}

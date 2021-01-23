package com.wm.LeeCode.LeeCode;


/**
 * @author wm
 * @Package com.wm.LeeCode.LeeCode
 * @date 2021/1/18 10:47
 */
public class LeeCode67 {
    public String addBinary(String a, String b) {
        //return Integer.toBinaryString(Integer.parseInt(a, 2) + Integer.parseInt(b, 2));
        StringBuilder result = new StringBuilder();

        int n = Math.max(a.length(), b.length()), carry = 0;
        for (int i = 0; i < n; i++) {
            carry += i < a.length() ? (a.charAt(a.length() - 1 -i) - '0') : 0;
            carry += i < b.length() ? (b.charAt(b.length() - 1 -i) - '0') : 0;
            result.append((char) (carry%2+'0'));
            carry /= 2;
        }
        if (carry > 0) {
            result.append('1');
        }
        return result.reverse().toString();
    }

    public static void main(String[] args) {
        java.lang.String a = "101";
        String b = "11111";
        System.out.println(new LeeCode67().addBinary(a, b));
    }
}

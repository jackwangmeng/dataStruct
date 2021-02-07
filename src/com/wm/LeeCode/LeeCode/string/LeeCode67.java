package com.wm.LeeCode.LeeCode.string;

public class LeeCode67 {
    public String addBinary(String a, String b) {
        //return Integer.toBinaryString(Integer.parseInt(a, 2) + Integer.parseInt(b, 2));

        StringBuilder str = new StringBuilder();
        int len = Math.max(a.length(), b.length()), result = 0;

        for (int i = 0; i < len; ++i) {
            result += i < a.length() ? (a.charAt(a.length() - i - 1) - '0') : 0;
            result += i < b.length() ? (b.charAt(b.length() - i - 1) - '0') : 0;
            str.append((char) (result % 2 + '0'));
            result /= 2;
        }
        if (result > 0) {
            str.append(1);
        }
        str.reverse();
        return str.toString();
    }

    public static void main(String[] args) {
        System.out.println(new LeeCode67().addBinary("1010", "1011"));
    }
}

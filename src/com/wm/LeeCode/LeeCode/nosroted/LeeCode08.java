package com.wm.LeeCode.LeeCode.nosroted;

public class LeeCode08 {
    public int myAtoi(String str){
        char[] chars = str.toCharArray();
        int n = str.length();
        int index = 0;
        while (index < n && chars[index] == ' '){
            index++;
        }
        if (index == n){
            return 0;
        }
        boolean flag = false;
        if (chars[index] == '-'){
            flag = true;
            index++;
        }else if(chars[index] == '+'){
            index++;
        }else if (!Character.isDigit(chars[index])){
            return 0;
        }

        int ans = 0;
        while (index < n && Character.isDigit(chars[index])){
            int digit = chars[index] - '0';
            if (ans > (Integer.MAX_VALUE - digit) / 10){
                return flag ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            ans = ans * 10 + digit;
            index++;
        }
        return flag ? -ans : ans;
    }

    public static void main(String[] args) {
        System.out.println(new LeeCode08().myAtoi("   -3232"));
    }
}

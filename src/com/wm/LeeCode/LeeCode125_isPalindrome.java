package com.wm.LeeCode;

public class LeeCode125_isPalindrome {
    public boolean isPalindrome(String s) {
        /*StringBuilder sb = new StringBuilder();
        int len = s.length();
        for (int i = 0 ; i < len ; i++){
            char ch = sb.charAt(i);
            if (Character.isLetterOrDigit(ch)){
                sb.append(Character.toLowerCase(ch));
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        return sb.toString().equals(stringBuilder.toString());*/

        StringBuilder sbPre = new StringBuilder();
        int len = s.length();
        for (int i = 0;i < len;i++){
            char ch = sbPre.charAt(i);
            if (Character.isLetterOrDigit(ch)){
                sbPre.append(Character.toLowerCase(ch));
            }
        }
        int n = sbPre.length();
        int left = 0,right = n - 1;
        while (left < right){
            if (Character.toLowerCase(sbPre.charAt(left)) != Character.toLowerCase(sbPre.charAt(right))){
                return false;
            }
            ++left;
            --right;
        }
        return true;
    }
}

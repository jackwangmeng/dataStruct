package com.wm.LeeCode.LeeCode.greedy.simple;

/**
 * @author wm
 * @Package com.wm.LeeCode.LeeCode.greedy.simple
 * @date 2020/11/19 14:13
 */
public class LeeCode392 {
    public boolean isSubsequence(String s, String t) {
        /*int sLen = s.length();
        int tLen = t.length();

        Character ch = s.charAt(0);
        int index = t.indexOf(ch);

        if (index != -1 && index + sLen < tLen){
            if (t.substring(index,index + sLen) == s){
                return true;
            }else{
                String temp = t.substring(index + 1);
                return isSubsequence(s,temp);
            }
        }
        return false;*/
        int sLen = s.length();
        int tLen = t.length();

        int i = 0, j = 0;
        while (i < sLen && j < tLen){
            if (s.charAt(i) == t.charAt(j)){
                i++;
            }
            j++;
        }
        return i == sLen;
    }

    public static void main(String[] args) {
        String s = "abc";
        String t = "ahbgdc";
        System.out.println(new LeeCode392().isSubsequence(s,t));
    }
}

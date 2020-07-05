package com.wm.LeeCode;

public class ToTransor {
    public String toTrans(int number){
        StringBuffer buffer = new StringBuffer();
        char[] chars={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};//罗列16进制0-15
        if(number==0) {
            return "0";
        }
        while(number!=0){
            int tmp = number & 15;
            buffer.append(chars[tmp]);
            number >>>= 4;//无符号右移，每次移动4位
    }
        return "0x"+buffer.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new ToTransor().toTrans(155));
    }
}

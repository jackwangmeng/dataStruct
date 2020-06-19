package com.wm.dataStruct;

public class LeeCode07 {
    public int reverse(int x){
        int res = 0;
        while (x != 0){
            int t = x % 10;
            if (res>214748364 || (res==214748364 && t>7)) {
                return 0;
            }
            //判断是否 小于 最小32位整数
            if (res<-214748364 || (res==-214748364 && t<-8)) {
                return 0;
            }
            res = res * 10 + t;
            x = x / 10;
        }
        return res;
    }
    public static void main(String[] args) {
        System.out.println(new LeeCode07().reverse(1234));
    }
}

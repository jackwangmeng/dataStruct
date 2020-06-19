package com.wm.dataStruct;

public class LeeCode09 {
    public boolean isPalindrome(int x) {
        if (x < 0 || ( x % 10 == 0 && x != 0)){
            return false;
        }

        int revertedNum = 0;
        while (x > revertedNum){
            revertedNum = revertedNum * 10 +  x % 10;
            x = x / 10;
        }

        return x == revertedNum || x == revertedNum / 10;
    }

    public static void main(String[] args) {
        System.out.println(new LeeCode09().isPalindrome(1211));
    }
}

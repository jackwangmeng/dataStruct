package com.wm.LeeCode.LeeCode.nosroted;

/**
 * @author wm
 * @Package com.wm.LeeCode.LeeCode
 * @date 2020/10/16 10:00
 */
public class LeeCode38 {
    public String countAndSay(int n) {
        if(n == 1){
            return "1";
        }
        StringBuffer res = new StringBuffer();
        String str = countAndSay(n - 1);
        int length = str.length();

        int start = 0;
        for (int i = 1; i < length + 1; i++){
            if (i == length){
                res.append(i - start).append(str.charAt(start));
            }else if (str.charAt(i) != str.charAt(start)){
                res.append(i - start).append(str.charAt(start));
                start = i;
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        int testData = 5;
        System.out.println(new LeeCode38().countAndSay(testData));
    }
}

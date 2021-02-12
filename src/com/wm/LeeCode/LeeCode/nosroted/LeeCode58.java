package com.wm.LeeCode.LeeCode.nosroted;

/**
 * @author wm
 * @Package com.wm.LeeCode.LeeCode
 * @date 2020/11/3 17:49
 */
public class LeeCode58 {
    public int lengthOfLastWord(String s) {
        /*if (!s.trim().isEmpty()){
            if (s.contains(" ")){
                String[] str = s.split(" ");
                int n = str[str.length-1].length();
                return n;
            }
            return s.length();
        }

        return 0;*/
        /*s = s.trim();
        int start = s.lastIndexOf(" ") - 1;
        return s.substring(start).length();*/
        if (s == null || s.length() == 0)
            return 0;
        int count = 0;
        for (int i = s.length() - 1; i >= 0; i--){
            if (s.charAt(i) == ' '){
                if (count == 0)
                    continue;

            }
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        String str = " ";
        System.out.println(new LeeCode58().lengthOfLastWord(str));
    }
}

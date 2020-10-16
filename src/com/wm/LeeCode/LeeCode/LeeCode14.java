package com.wm.LeeCode.LeeCode;

public class LeeCode14 {
    public String longestCommonPrefix(String[] strs) {
       /* if (strs == null || strs.length == 0){
            return "";
        }
        String pre = strs[0];
        int count = strs.length;
        for (int i = 1; i < count; i++){
            pre = longestCommonPrefix(pre,strs[i]);
            if (pre.length() == 0){
                break;
            }
        }
        return pre;
    }

    private String longestCommonPrefix(String pre, String str) {
        int len = Math.min(pre.length(),str.length());
        int index = 0;
        while (index < len && pre.charAt(index) == str.charAt(index)){
            index++;
        }
        return pre.substring(0,index);
    }*/
        if (strs == null || strs.length == 0) {
            return "";
        }
        int len = strs[0].length();
        int count = strs.length;
        for (int i = 0; i < len; i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < count; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }
}

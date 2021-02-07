package com.wm.LeeCode.LeeCode.string;

import com.sun.deploy.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeeCode65 {
    public boolean isNumber(String s) {
        /*boolean flag = true;
        String[] sums = {"0","1","2","3","4","5","6","7","8","9"};
        List<String> list = new ArrayList<String>(Arrays.asList(sums));
        for (int i = 0; i < s.toCharArray().length; ++i) {

            char ch = s.charAt(i);
            if(i == 0 && ("e".equals(String.valueOf(ch)) || "E".equals(String.valueOf(ch)))) return false;

            if (list.contains(ch)) continue;
            if ("e".equals(String.valueOf(ch).toLowerCase())) {
                if (i < s.length() - 1) {
                    char c = s.charAt(i + 1);
                    if (list.contains(c)) continue;
                    else {
                        flag = false;
                    }
                }
            }
            if ("-".equals(String.valueOf(ch)) || "+".equals(String.valueOf(ch))) {
                if (i < s.length() - 1) {
                    char c = s.charAt(i + 1);
                    if (list.contains(c)) continue;
                    else {
                        flag = false;
                    }
                }
            }
            if (".".equals(String.valueOf(ch))) {
                if (i < s.length() - 1) {
                    char c = s.charAt(i + 1);
                    if (list.contains(c)) continue;
                    else {
                        flag = false;
                    }
                }
            }
        }
        return flag;*/
        if(s==null||s.length()==0) return false;
        boolean numSeen=false;
        boolean dotSeen=false;
        boolean eSeen=false;
        char arr[]=s.trim().toCharArray();
        for(int i=0; i<arr.length; i++){
            if(arr[i]>='0'&&arr[i]<='9'){
                numSeen=true;
            }else if(arr[i]=='.'){
                if(dotSeen||eSeen){
                    return false;
                }
                dotSeen=true;
            }else if(arr[i]=='E'||arr[i]=='e'){
                if(eSeen||!numSeen){
                    return false;
                }
                eSeen=true;
                numSeen=false;
            }else if(arr[i]=='+' || arr[i]=='-'){
                if(i != 0 && (arr[i-1] != 'e' || arr[i-1] != 'E')) {
                    return false;
                }
            }else{
                return false;
            }
        }
        return numSeen;

    }

    public static void main(String[] args) {
        System.out.println(new LeeCode65().isNumber("1.e9"));
    }
}

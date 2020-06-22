package com.wm.LeeCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeeCode17 {
    Map<String,String> phone = new HashMap<String,String>(){
        {
            put("2", "abc");
            put("3", "def");
            put("4", "ghi");
            put("5", "jkl");
            put("6", "mno");
            put("7", "pqrs");
            put("8", "tuv");
            put("9", "wxyz");
        }
    };

    List<String> op = new ArrayList<String>();
    public void backtrack(String combination,String next_digits){
        if (next_digits.length() == 0){
            op.add(combination);
        }else {
            String digit = next_digits.substring(0,1);
            String letters = phone.get(digit);
            for (int i = 0;i < letters.length();i++){
                String lt = phone.get(digit).substring(i,i + 1);
                backtrack(combination + lt,next_digits.substring(1));
            }
        }
    }

    public List<String> letterCombinations(String digits){
        if (digits.length() != 0){
            backtrack("",digits);
        }
        return op;
    }
}

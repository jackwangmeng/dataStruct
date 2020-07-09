package com.wm.LeeCode;

import java.util.ArrayList;
import java.util.List;

public class LeeCode21 {
    /*public List<String> generateParenthesis(int n) {
        List<String> combinations = new ArrayList<>();
        generateAll(new char[2 * n], 0 , combinations);
        return combinations;
    }

    private void generateAll(char[] current, int pos, List<String> result) {
        if (pos == current.length){
            if (valid(current)){
                result.add(new String(current));
            }
        }else {
            current[pos] = '(';
            generateAll(current,pos + 1,result);
            current[pos] = ')';
            generateAll(current,pos + 1,result);
        }
    }

    private boolean valid(char[] current) {
        int balance = 0;
        for (char c : current){
            if (c == '('){
                balance++;
            }else {
                balance--;
            }
            if (balance < 0){
                return false;
            }
        }
        return (balance == 0);
    }*/
    /*public List<String> generateParenthesis(int n) {
        List<String> combinations = new ArrayList<>();
        backtrack(combinations,new StringBuilder(),0,0,n);
        return combinations;
    }

    private void backtrack(List<String> combinations, StringBuilder stringBuilder, int open, int close, int n) {
        if (stringBuilder.length() == 2*n){
            combinations.add(stringBuilder.toString());
            return;
        }
        if (open < n){
            stringBuilder.append('(');
            backtrack(combinations,stringBuilder,open + 1,close,n);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
        if (close < n){
            stringBuilder.append(')');
            backtrack(combinations,stringBuilder,open,close + 1,n);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
    }*/

    ArrayList[] cache = new ArrayList[100];
    public List<String> generate(int n) {
        if (cache[n] != null){
            return cache[n];
        }
        ArrayList<String> combinations = new ArrayList();
        if (n == 0){
            combinations.add("");
        }else {
            for (int c = 0; c < n; ++c){
                for (String left : generate(c)){
                    for (String right : generate(n - 1 - c)){
                        combinations.add("(" + left + ")" + right);
                    }
                }
            }
        }
        cache[n] = combinations;
        return combinations;
    }
    public List<String> generateParenthesis(int n) {
      return generate(n);
    }

    public static void main(String[] args) {
        System.out.println(new LeeCode21().generateParenthesis(3));
    }
}

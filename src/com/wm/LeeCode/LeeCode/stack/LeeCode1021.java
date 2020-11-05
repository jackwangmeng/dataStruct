package com.wm.LeeCode.LeeCode.stack;

import java.util.Stack;

/**
 * @author wm
 * @Package com.wm.LeeCode.LeeCode.stack
 * @date 2020/11/5 11:10
 */
public class LeeCode1021 {

    public String removeOuterParentheses(String S) {
        /*StringBuilder sb = new StringBuilder();
        int level = 0;
        for (char c : S.toCharArray()) {
            if (c == ')') --level;
            if (level >= 1) sb.append(c);
            if (c == '(') ++level;
        }
        return sb.toString();*/

        StringBuilder ans = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        int start = 0;
        int end = 0;

        boolean flag = false;

        for (int i = 0; i < S.length(); i++){
            char ch = S.charAt(i);

            if (ch == '('){
                stack.push(ch);
                if (!flag){
                    start = i;
                    flag = true;
                }
            }

            if (ch == ')'){
                stack.pop();
                if (stack.empty()){
                    end = i;
                    ans.append(S.substring(start + 1,end));
                    flag = false;
                }
            }
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        String str = "(()())(())";
        System.out.println(new LeeCode1021().removeOuterParentheses(str));
    }
}

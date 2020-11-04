package com.wm.LeeCode.LeeCode.stack;

import java.util.Stack;

/**
 * @author wm
 * @Package com.wm.LeeCode.LeeCode.stack
 * @date 2020/11/4 14:37
 */
public class LeeCode844 {
    public boolean backspaceCompare(String S, String T) {
        return handle(S).equals(handle(T));
    }

    public String handle(String str){
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < str.length(); i++){
            if (str.charAt(i) == '#'){
                if (!stack.empty()){
                    stack.pop();
                }
                continue;
            }{
                stack.push(str.charAt(i));
            }

        }
        return stack.toString();
    }

    public static void main(String[] args) {
        String s = "ab##";
        String t = "a#d#";
        System.out.println(new LeeCode844().backspaceCompare(s,t));
    }
}

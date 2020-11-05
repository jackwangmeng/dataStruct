package com.wm.LeeCode.LeeCode.stack;

import javax.management.Query;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author wm
 * @Package com.wm.LeeCode.LeeCode.stack
 * @date 2020/11/5 11:46
 */
public class LeeCode1047 {
    public String removeDuplicates(String S) {
        Stack<Character> stack = new Stack<>();
        if (S == null || S.length() == 0){
            return "";
        }
        for (char ch : S.toCharArray()){
            if (stack.isEmpty() || stack.peek() != ch){
                stack.push(ch);
            }else {
                stack.pop();
            }

        }

        StringBuilder res = new StringBuilder();
        for (Character s : stack){
            res.append(s);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        String str = "abbaca";
        System.out.println(new LeeCode1047().removeDuplicates(str));
    }
}

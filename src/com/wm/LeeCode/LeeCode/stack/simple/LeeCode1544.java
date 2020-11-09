package com.wm.LeeCode.LeeCode.stack.simple;

import java.util.Stack;

/**
 * @author wm
 * @Package com.wm.LeeCode.LeeCode.stack
 * @date 2020/11/6 16:36
 */
public class LeeCode1544 {

    public String makeGood(String s){
        /*List<Character> result = new ArrayList<>();
        char[] ch = s.toCharArray();
        for (int i = 0; i < ch.length; i++){
            result.add(ch[i]);
            int n = result.size();
            if (n >= 2 && (result.get(n - 1) + 32 == result.get(n - 2) || result.get(n - 1) - 32 == result.get(n - 2))){
                result.remove(n - 1);
                result.remove(n - 2);
            }
        }
        StringBuilder str = new StringBuilder();
        for (Character c : result){
            str.append(c);
        }
        return str.toString();*/

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if (!stack.empty()){
                 if (ch == (stack.peek() + 'a' - 'A') || (ch == stack.peek() + 'A' - 'a' )){
                     stack.pop();
                }else {
                     stack.push(ch);
                 }
            }else {
                stack.push(ch);
            }
        }
        StringBuilder result = new StringBuilder();
        while (!stack.empty()){
            result.append(stack.pop());
        }
        return result.reverse().toString();
    }

    public static void main(String[] args) {
        String str = "leEeetcode";
        System.out.println(new LeeCode1544().makeGood(str));
    }
}

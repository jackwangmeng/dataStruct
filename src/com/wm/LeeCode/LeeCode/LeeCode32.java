package com.wm.LeeCode.LeeCode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author wm
 * @Package com.wm.LeeCode.LeeCode
 * @date 2020/10/14 17:35
 */
public class LeeCode32 {
    public int longestValidParentheses(String s) {
        /*int maxans = 0;
        Deque<Integer> stack = new LinkedList<Integer>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == '('){
                stack.push(i);
            }else {
                stack.pop();
                if (stack.isEmpty()){
                    stack.push(i);
                }else {
                    maxans = Math.max(maxans , i - stack.peek());
                }
            }
        }
        return maxans;*/

        int left = 0, right = 0, maxLength = 0;
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == '('){
                left++;
            }else {
                right++;
            }
            if (left == right){
                maxLength = Math.max(maxLength, 2 * right);
            }else if (right > left){
                left = right = 0;
            }
        }

        left = right = 0;
        for (int i = s.length() - 1; i >= 0; i--){
            if (s.charAt(i) == '('){
                left++;
            }else {
                right++;
            }
            if (left == right){
                maxLength = Math.max(maxLength , 2*left);
            }else if (left > right){
                left = right = 0;
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        String s = "()()((";
        System.out.println(new LeeCode32().longestValidParentheses(s));
    }
}
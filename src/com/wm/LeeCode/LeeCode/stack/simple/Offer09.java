package com.wm.LeeCode.LeeCode.stack.simple;

import java.util.Stack;

/**
 * @author wm
 * @Package com.wm.LeeCode.LeeCode.stack.simple
 * @date 2020/11/6 17:54
 */
public class Offer09 {
    class CQueue {
        Stack<Integer> stack1;//add param into stack
        Stack<Integer> stack2;//reverse the paramsList
        public CQueue() {
            stack1 = new Stack<>();
            stack2 = new Stack<>();
        }

        public void appendTail(int value) {
            stack1.push(value);
        }

        public int deleteHead() {
            if (!stack2.isEmpty()){
                return stack2.pop();
            }
            if (stack1.isEmpty())
                return -1;
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
            return stack2.pop();
        }
    }
}

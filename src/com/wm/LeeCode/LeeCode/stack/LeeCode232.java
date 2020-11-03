package com.wm.LeeCode.LeeCode.stack;

import com.wm.LeeCode.LeeCode.LeeCode53;

import java.util.Stack;

/**
 * @author wm
 * @Package com.wm.LeeCode.LeeCode.stack
 * @date 2020/11/3 12:10
 */
public class LeeCode232 {
    class MyQueue {
        Stack<Integer> s1;
        private Stack<Integer> s2;
        int front;
        /** Initialize your data structure here. */
        public MyQueue() {
            s1 = new Stack<>();
            s2 = new Stack<>();
        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            if (s1.empty()){
                front = x;
            }
            s1.push(x);
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            if (s2.isEmpty()){
                while (!s1.isEmpty()){
                    s2.push(s1.pop());
                }
            }
            return s2.pop();
        }

        /** Get the front element. */
        public int peek() {
            if (!s2.isEmpty()){
                return s2.peek();
            }
            return front;
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            return s1.isEmpty() && s2.isEmpty();
        }
    }
}

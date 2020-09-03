package com.wm.leecodes.LeeCode;

import java.util.HashMap;
import java.util.Stack;

public class LeeCode20 {
    public static void main(String[] args) {
        System.out.println(new LeeCode20());
    }
    class Solution {
        private HashMap<Character,Character> mappings;
        public Solution(){
            this.mappings = new HashMap<Character, Character>();
            this.mappings.put(')','(');
            this.mappings.put('}','{');
            this.mappings.put(']','[');
        }

        public boolean isValid(String s) {
            Stack<Character> stack = new Stack<Character>();
            for (int i = 0 ;i < s.length() ; i++){
                char c = s.charAt(i);
                if (this.mappings.containsKey(c)){
                    char topElement = stack.empty() ? '#' : stack.pop();
                    if (topElement != this.mappings.get(c)){
                        return false;
                    }else {
                        stack.push(c);
                    }
                }

            }
            return stack.isEmpty();
        }
    }
}

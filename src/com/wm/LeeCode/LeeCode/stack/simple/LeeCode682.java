package com.wm.LeeCode.LeeCode.stack.simple;
import java.util.Stack;

/**
 * @author wm
 * @Package com.wm.LeeCode.LeeCode.stack
 * @date 2020/11/4 13:46
 */
public class LeeCode682 {
    public int calPoints(String[] ops){
        Stack<Integer> stack = new Stack<>();
        for (String op : ops){
            switch (op){
                case "C":
                    stack.pop();
                    break;
                case "D":
                    stack.push(stack.peek() * 2);
                    break;
                case "+":
                    Integer var = stack.pop();
                    Integer var1 = stack.peek();
                    stack.push(var);
                    stack.push(var + var1);
                    break;
                default:
                    stack.push(Integer.parseInt(op));
            }
        }
        int res = 0;
        while (!stack.empty()) {
            res += stack.pop();
        }
        //return res;
        return stack.stream().reduce(Integer::sum).orElse(0);
    }

    public static void main(String[] args) {
        String[] str = {"5","2","C","D","+"};
        System.out.println(new LeeCode682().calPoints(str));
    }
}

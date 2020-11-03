package com.wm.LeeCode.LeeCode.stack;

import javax.swing.plaf.synth.SynthTextAreaUI;
import java.util.*;

/**
 * @author wm
 * @Package com.wm.LeeCode.LeeCode.stack
 * @date 2020/11/3 13:56
 */
public class LeeCode496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        Map<Integer,Integer> map = new HashMap<>();
        int[] result = new int[nums1.length];
        for (int i = 0; i < nums2.length; i++){
            while (!stack.empty() && nums2[i] > stack.peek()){
                map.put(stack.pop(),nums2[i]);
            }
            stack.push(nums2[i]);
        }
        while (!stack.empty()){
            map.put(stack.pop(),-1);
        }

        for (int i = 0; i < nums1.length; i++){
            if (map.containsKey(nums1[i])){
                result[i] = map.get(nums1[i]);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] num1 = {4,1,2};
        int[] num2 = {1,3,4,2};
        System.out.println(new LeeCode496().nextGreaterElement(num1,num2));
    }
}

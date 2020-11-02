package com.wm.LeeCode.LeeCode.stack;

import java.util.HashSet;
import java.util.Set;

/**
 * @author wm
 * @Package com.wm.LeeCode.LeeCode.stack
 * @date 2020/11/2 14:34
 */
public class LeeCode349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> temp1 = new HashSet<>();
        Set<Integer> temp2 = new HashSet<>();
        //set集合去重处理
        for (int num : nums1){
            temp1.add(num);
        }
        for (int i = 0; i < nums2.length; i++){
            if (temp1.contains(nums2[i])){
                temp2.add(nums2[i]);
            }
        }
        int i = 0;
        int[] result = new int[temp2.size()];
        for (int num : temp2){
            result[i++] = num;
        }
        return result;
    }
}

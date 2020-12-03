package com.wm.LeeCode.LeeCode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author wm
 * @Package com.wm.LeeCode.LeeCode
 * @date 2020/11/20 17:24
 */
public class LeeCode41 {
    public int firstMissingPositive(int[] nums) {
        /*int len = nums.length;
        int[] res = new int[len + 1];

        for (int i = 0; i < len; i++){
            if (nums[i] > 0 && nums[i] <= len){
                res[nums[i]]++;
            }
        }

        for (int i = 1; i < len + 1; i++){
            if (res[i] == 0){
                return i;
            }
        }
        return len + 1;*/

        int len = nums.length;

        Set<Integer> hashSet = new HashSet<>();
        for (Integer num : nums){
            hashSet.add(num);
        }

        for (int i = 0; i <= len; i++){
            if (!hashSet.contains(i)){
                return i;
            }
        }
        return len + 1;
    }

    public static void main(String[] args) {
        int[] nums = {3,4,-1,1};
        System.out.println(new LeeCode41().firstMissingPositive(nums));
    }
}

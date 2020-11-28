package com.wm.LeeCode.LeeCode;

import java.util.Arrays;

/**
 * @author wm
 * @Package com.wm.LeeCode.LeeCode
 * @date 2020/11/20 17:24
 */
public class LeeCode41 {
    public int firstMissingPositive(int[] nums) {
        if (nums.length == 0){
            return 0;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++){
            if (nums[i] < 0){
                continue;
            }else if (nums[i] == i){
                continue;
            }else {
                return i;
            }
        }
        return nums[nums.length - 1] + 1;
    }

    public static void main(String[] args) {
        int[] nums = {3,4,-1,1};
        System.out.println(new LeeCode41().firstMissingPositive(nums));
    }
}

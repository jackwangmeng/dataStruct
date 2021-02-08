package com.wm.LeeCode.LeeCode.array;

import java.util.Arrays;

/**
 * @author wm
 * @Package com.wm.LeeCode.LeeCode.array
 * @date 2021/2/8 11:23
 */
public class LeeCode75 {
    public void sortColors(int[] nums) {
        //法一：内部函数调用排序
        //Arrays.sort(nums);

        int len = nums.length;
        int pre = 0, idx = 0;


        while (idx < len) {
            if(nums[idx] == 0) {
                int temp = nums[idx];
                nums[idx] = nums[pre];
                nums[pre] = 0;
                ++pre;
            }
            ++idx;
        }
        idx = pre;
        while (idx < len) {
            if(nums[idx] == 1) {
                int temp = nums[idx];
                nums[idx] = nums[pre];
                nums[pre] = 1;
                ++pre;
            }
            ++idx;
        }
    }
}

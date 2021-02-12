package com.wm.LeeCode.LeeCode.nosroted;

/**
 * @author wm
 * @Package com.wm.leecode.LeeCode
 * @date 2020/8/11 10:40
 */
public class LeeCode26 {
    public int removeDuplicates(int[] nums){
        if (nums.length <= 1)
            return Integer.parseInt(nums.toString());
        int i = 0;
        for (int j = 0 ; j < nums.length; j++){
            if (nums[j] != nums[i]){
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }
}

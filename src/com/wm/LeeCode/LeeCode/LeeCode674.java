package com.wm.LeeCode.LeeCode;

public class LeeCode674 {
    public int findLengthOfLCIS(int[] nums) {
        if(nums.length <= 1) {
            return nums.length;
        }
        int result = 1;
        int temp = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i]<nums[i+1]) {
                temp++;
            } else {
                temp = 1;
            }
             result = temp > result ? temp : result;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,5,4,7};
        System.out.println(new LeeCode674().findLengthOfLCIS(nums));
    }
}

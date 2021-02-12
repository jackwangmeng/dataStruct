package com.wm.LeeCode.LeeCode.nosroted;

import java.util.Arrays;

/**
 * @author wm
 * @Package com.wm.LeeCode.LeeCode
 * @date 2020/10/13 8:50
 */
public class LeeCode31 {
    //1
    public void nextPermutation1(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i+1] <= nums[i]){
            i--;
        }
        if (i >= 0){
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i]){
                j--;
            }
            swap(nums,i,j);
        }
        reverse(nums,i + 1);
    }

    private void reverse(int[] nums, int start) {
        int i = start,j = nums.length - 1;
        while (i < j){
            swap(nums,i,j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    //2
    public void nextPermutation2(int[] nums) {
        if(nums == null || nums.length <= 1){
            return;
        }
        Boolean flag = false;
        for (int i = nums.length - 2; i >= 0 ; --i) {
            if (nums[i] >= nums[i+1]) continue;;
            flag = true;
            int j = nums.length - 1;
            while (nums[j] <= nums[i]) j--;
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            Arrays.sort(nums,i+1,nums.length);
            break;
        }
        if (!flag){
            Arrays.sort(nums);
        }
    }

}

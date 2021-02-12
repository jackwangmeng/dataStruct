package com.wm.LeeCode.LeeCode.nosroted;

/**
 * @author wm
 * @Package com.wm.leecode.LeeCode
 * @date 2020/8/11 11:00
 */
public class LeeCode27 {
    public int removeElement(int[] nums, int val) {
      int i = 0;
      for (int j = 0 ; j < nums.length; j++){
          if (nums[j] != nums[i]){
              nums[i] = nums[j];
              i++;
          }
      }
      return i;
    }
}

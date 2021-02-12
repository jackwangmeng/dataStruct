package com.wm.LeeCode.LeeCode.leecodeList;

public class LeeCode80 {
    /*public int removeDuplicates(int[] nums) {
        int i = 1, count = 1, length = nums.length;
        while (i < length) {
            if (nums[i] == nums[i - 1]) {
                ++count;
                if (count > 2) {
                    this.remElement(nums, i);
                    --i;
                    --length;
                }
            } else {
                count = 1;
            }
            ++i;
        }
        return length;
    }

    private int[] remElement(int[] nums, int index) {
        for (int i = index + 1; i < nums.length; ++i) {
            nums[i - 1] = nums[i];
        }
        return nums;
    }*/

    public int removeDuplicates(int[] nums) {

        int j = 1, count = 1;
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] == nums[i - 1]) {
                count++;
            } else {
                count = 1;
            }
            if (count <= 2) {
                nums[j++] = nums[i];
            }
        }

        int index = 0;
        for (int num : nums) {
            if(index < 2 || nums[index - 2] < num) {
                nums[index++] = num;
            }
        }
        return index;
    }
}

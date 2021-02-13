package com.wm.LeeCode.LeeCode.leecodeList;

public class LeeCode81 {
    public boolean search(int[] nums, int target) {
        if (nums.length == 0 || target < 0) {
            return false;
        }
        int i = 0;
        while (i < nums.length) {
            if (nums[i] == target) {
                return true;
            }
            ++i;
        }
        return false;
    }
}

package com.wm.LeeCode.LeeCode.nosroted;

/**
 * @author wm
 * @Package com.wm.LeeCode.LeeCode
 * @date 2020/10/15 14:24
 */
public class LeeCode33 {
    public int search(int[] nums, int target) {
        int length = nums.length;
        if (length == 0){
            return -1;
        }
        if (length == 1){
            return nums[0] == target ? 0 : -1;
        }
        int left = 0, right = length - 1;
        while (left <= right){
            int mid = (right + left) >> 2;
            if (nums[mid] == target){
                return mid;
            }
            if (nums[0] <= nums[mid]){
                if (nums[0] <= target && target < nums[mid]){
                    right = mid - 1;
                }else {
                    left = mid + 1;
                }
            }else {
                if (nums[mid] < target && target <= nums[right]){
                    left = mid + 1;
                }else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}

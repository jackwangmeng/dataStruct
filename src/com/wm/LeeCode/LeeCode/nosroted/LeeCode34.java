package com.wm.LeeCode.LeeCode.nosroted;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wm
 * @Package com.wm.LeeCode.LeeCode
 * @date 2020/10/19 15:14
 */
public class LeeCode34 {

    /*public int[] searchRange(int[] nums, int target) {
        int[] result = {-1,-1};

        int leftIndex = extremeInsertionIndex(nums,target, true);
        if (leftIndex == nums.length || nums[leftIndex] != target){
            return result;
        }

        result[0] = leftIndex;
        result[1] = extremeInsertionIndex(nums,target,false) - 1;
        return result;
    }

    private int extremeInsertionIndex(int[] nums, int target, boolean left) {
        int lo = 0;
        int length = nums.length;

        while (lo < length){
            int mid = (lo + length) >> 1;
            if (nums[mid] > target || (left && target == nums[mid])){
                length = mid;
            }else {
                lo = mid + 1;
            }
        }
        return lo;
    }*/


    public int[] searchRange(int[] nums, int target) {
        int length = nums.length;
        int[] defaultResult = {-1,-1};
        List<Integer> list = new ArrayList<Integer>();
        if (length >= 1){
            for (int i = 0; i < length; i++){
                if (nums[i] == target){
                    list.add(i);
                }
            }
            int[] result = new int[list.size()];
            printArray(list,defaultResult);
            if (list.isEmpty()){
                return defaultResult;
            }else if (list.size() == 1){
                return new int[]{list.get(0),list.get(0)};
            }else{
                return defaultResult;
            }

        }
        return defaultResult;
    }

    private int[] printArray(List<Integer> message, int array[]){
        for (int i = 0; i < message.size(); i++){
            if (i == 0){
                array[0] = message.get(0);
            }else {
                array[1] = message.get(i);
            }
        }
        return array;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5,7,7,8,8,10};
        System.out.println(new LeeCode34().searchRange(nums,8));
    }
}

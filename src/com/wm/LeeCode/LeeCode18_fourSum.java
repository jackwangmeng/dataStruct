package com.wm.LeeCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeeCode18_fourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 4){
            return result;
        }
        Arrays.sort(nums);
        int length = nums.length;
        for(int k=0;k<length-3;k++) {
            /*当k的值与前面的值相等时忽略*/
            if (k > 0 && nums[k] == nums[k - 1]) {
                continue;
            }
            int min1 = nums[k] + nums[k+1] + nums[k+2] + nums[k+3];
            if (min1 > target){
                break;
            }
            int max1 = nums[k] + nums[length-1]+nums[length-2]+nums[length-3];
            if (max1 < target){
                continue;
            }

            for (int i=k+1;i<length-2;i++){
                if(i>k+1&&nums[i]==nums[i-1]){
                    continue;
                }
                int j = i+1;
                int h = length - 1;
                int min = nums[k] + nums[i] + nums[j] + nums[j+1];
                if (min > target){
                    continue;
                }
                int max = nums[k] + nums[i] + nums[h] + nums[h -1];
                if (max < target){
                    continue;
                }

                while (j < h){
                    int curr = nums[k] + nums[i] + nums[j] + nums[h];
                    if (curr == target){
                        result.add(Arrays.asList(nums[k],nums[i],nums[j],nums[h]));
                        j++;
                        while (j < h && nums[j] == nums[j - 1]){
                            j++;
                        }
                        h--;
                        while (j < h && nums[h] == nums[h + 1]){
                            h--;
                        }
                    }else if (curr > target){
                        h--;
                    }else {
                        j++;
                    }
                }
            }
        }
        return result;
    }
}

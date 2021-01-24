package com.wm.interviewing;

import java.util.HashMap;
import java.util.Map;

public class ProductTest {
    public int product(int[] nums) {

        int length = nums.length;
        if(nums == null || length == 0){
            return 0;
        }

        //记录结果
        int result = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < length - 1; i++) {
            //遍历参数集合，获得两数乘积值
            for(int j = i + 1; j < length; j++ ) {
                //乘积结果值
                int multipartTemp = nums[i] * nums[j];
                //判断结果集合中是否存在相同乘积值
                if(map.containsKey(multipartTemp)) {
                    //及乘积值已经存在集合中，存在相同组合，则结果加上对应的value值，更新结果
                    result +=  map.get(multipartTemp);
                    //乘积算上当前这次，乘积相同值组合加一
                    map.put(multipartTemp, map.get(multipartTemp) + 1);
                }else{
                    // 乘积值不在集合中，则value值 + 1(出现次数)
                    map.put(multipartTemp, 1);
                }
            }
        }
        //按照排列组合，四个数一共可以不重复排列8次
        return result * 8;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 4, 6};
        System.out.println(new ProductTest().product(nums));
    }
}

package com.wm.LeeCode.LeeCode.stack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wm
 * @Package com.wm.LeeCode.LeeCode.stack
 * @date 2020/11/5 16:50
 */
public class LeeCode1441 {
    public List<String> buildArray(int[] target, int n){
        List<String> result = new ArrayList<>();
        for (int i = 1,j = 0; i <= n && j < target.length; i++){
            if (i < target[j]){
                result.add("Push");
                result.add("Pop");
            }else if (i == target[j]){
                result.add("Push");
                j++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] target = {1,3};
        System.out.println(new LeeCode1441().buildArray(target,3));
    }
}

package com.wm.leecode.LeeCode;

import java.util.TreeSet;

/**
 * @author wm
 * @Package com.wm.leecode.LeeCode
 * @date 2020/8/26 8:58
 */
public class LeeCode1562 {
    public int findLatestStep(int[] arr, int m) {
        TreeSet<Integer> set = new TreeSet<>();
        set.add(0);
        set.add(arr.length + 1);
        if (arr.length == m){
            return arr.length;
        }
        int n = arr.length;
        for (int i = n - 1; i >= 0; i--){
            int index = arr[i];
            int a = set.lower(index);
            int b = set.higher(index);
            if ((index - a - 1 == m) || (b - index - 1 == m)){
                return i;
            }
            set.add(index);
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3,4,5,1,2};
        int m = 3;
        System.out.println(new LeeCode1562().findLatestStep(arr,m));
    }
}

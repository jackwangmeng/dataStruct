package com.wm.LeeCode.LeeCode.heap.simple;

import java.util.Arrays;

/**
 * @author wm
 * @Package com.wm.LeeCode.LeeCode.heap.simple
 * @date 2020/11/13 16:50
 */
public class Offer40 {
    public int[] getLeastNumbers(int[] arr, int k) {
        Arrays.sort(arr);
        return arraySub(arr,0,k);
    }

    public static int[] arraySub(int[] data,int start,int end){
        int[] C=new int[end-start];//新建数组C长度为start-end
        int j=0;
        for(int i=start;i<end;i++){
            C[j]=data[i];
            j++;
        }
        return C;//返回截取数组的地址
    }
}

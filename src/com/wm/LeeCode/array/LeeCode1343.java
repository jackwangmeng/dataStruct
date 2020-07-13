package com.wm.LeeCode.array;

public class LeeCode1343 {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int sum = 0 , result = 0;
        int sumTarget = k * threshold;
        for (int i = 0; i < k; i++){
            sum += arr[i];
        }
        int addr = sum - sumTarget;
        if (addr >= 0){
            result++;
        }
        int pos = k;
        for (int i = 0; i < arr.length - k; i++){
            addr = addr + arr[pos] - arr[i];
            if (addr >= 0){
                result++;
            }
            pos++;
        }
        return result;
    }
}

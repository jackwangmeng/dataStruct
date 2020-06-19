package com.wm.dataStruct;

public class demo_sort {
    public static void main(String[] args) {
        int[] number = new int[]{1,4,6,2,3,10,8};
        int i , j;
        for (i=0;i<number.length-1;i++){
            for (j = 0;j < number.length-1;j++){
                if (number[j]>number[j+1]){
                    int sweep = number[j];
                     number[j] = number[j+1];
                     number[j+1] = sweep;
                }
            }
        }
        System.out.println("从小到大排序：");
        for (i = 0;i<number.length;i++){
            System.out.print(number[i]+ "->");
        }
    }
}

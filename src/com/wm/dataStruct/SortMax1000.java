package com.wm.dataStruct;

import java.util.Arrays;
import java.util.Random;
import java.util.UUID;

public class SortMax1000 {

    /*有1万个数组，每个数组有1000个整数，每个数组都是降序的，从中找出最大的N个数，N<1000
    *
    直接暴力求解，将20个数组合并，然后排序，取出N个数
    * */

    private static final Integer ROWS = 10000;
    private static final Integer COLS = 1000;

    private Integer[][] data = new Integer[ROWS][COLS];

    public static void main(String[] args) {


// 方法1，直接将10000个数组合并，排序，然后取前1000个
        // 复杂度是 1000000log(1000000)
        Integer[] allData = new Integer[10000*1000];
        int a = 0;
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                allData[a++] = (int) (20 + Math.floor(Math.random()*1000000));
            }
        }

        Arrays.sort(allData);

        Integer n = 1000;
        Integer[] result = Arrays.copyOfRange(allData, 0, n);
        System.out.println("method 1 result:    " + Arrays.toString(result));


        //方法二// 方法2，归并，先归并前两个数组，取前1000个数据。将得到的结果再与第3个归并，重复
        //    // 考虑一下,10000个数组先两两归并，得到5000个；5000个再两两归并，得到2500个。等等，直到最后1个
        //    // 但这样归并的次数和从前往后两两归并的次数是一样的？所以还是 上述的从前往后好了
        //    // 复杂度是 9999*1000
        //Integer[] result2 = allData[0];

    }

    //方法二
/**
 *
 * @param first
 *            数组1
 * @param second
 *            数组2
 * @param n
 *            数组的长度，假定 first 和 second 的长度均为 n
 * @return 返回一个长度为 n 的数组
 */

    private static Integer[] merge(Integer[] first, Integer[] second, int n) {
        Integer[] temp = new Integer[n];

        int f = 0;
        int s = 0;

        int i = 0;

        while (i != n && f <= n && s <= n) {
            if (first[f] < second[s]) {
                temp[i++] = second[s];
            } else {
                temp[i++] = second[s++];
            }
        }
        return temp;
    }

}

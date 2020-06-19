package com.wm.dataStruct;

public class QuickSort {
    public static void main(String[] args) {
        int[] number = new int[] {3,45,78,64,52,11,64,55,99,11,18};
        System.out.println(arrayToString(number,"未排序"));
        sort(number,0,number.length-1);
        System.out.println(arrayToString(number,"排序"));
    }

    private static void sort(int arr[], int low, int high){
        int l = low;
        int h = high;
        int k = arr[low];
        while (l < h) {
            // 从后往前比较
            while (l < h && arr[h] >= k) { // 如果没有比关键值小的，比较下一个，直到有比关键值小的交换位置，然后又从前往后比较
                h--;// h=6
            }
            if (l < h) {
                int temp = arr[h];
                arr[h] = arr[l];
                arr[l] = temp;
                //进行过一次替换后，没必要将替换后的两值再次比较，所以i++直接下一位与k对比
                l++;
            }
            // 从前往后比较
            while (l < h && arr[l] <= k) { // 如果没有比关键值大的，比较下一个，直到有比关键值大的交换位置
                l++;
            }
            if (l < h) {
                int temp = arr[h];
                arr[h] = arr[l];
                arr[l] = temp;
                h--;
            }
            // 此时第一次循环比较结束，关键值的位置已经确定了。左边的值都比关键值小，右边的值都比关键值大，但是两边的顺序还有可能是不一样的，进行下面的递归调用
        }
        if (l > low)//先判断l>low再次经行左边排序
            sort(arr, low, l - 1);// 左边序列。第一个索引位置到关键值索引-1
        if (h < high)//左边依次排序执行完递归后，弹栈进行右边排序
            sort(arr, l + 1, high);// 右边序列。从关键值索引+1到最后一个
    }
    // 打印数组的方法
    private static void print(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            if (i != (arr.length - 1)) {
                System.out.print(arr[i] + ",");
            } else {
                System.out.print(arr[i] + "]");
                System.out.println();
            }
        }
    }

    private static String arrayToString(int[] arr,String flag){
        String str = "数组为("+flag+"):";
        for (int a : arr){
            str += a + "\t";
        }
        return str;
    }

    /*
    * 1.线程是进程的一部分，一个进程包括多个线程
    * 2.进程是资源分配的最小单位，线程是程序执行的最小单位
    * 3.CPU切换线程的花费比进程小，创建一个线程比一个进程的花销小
    * 4.线程占用的资源比进程少得多
    * 5.进程对资源保护要求高，开销大，效率相对较低，线程对资源保护要求低，开销小，效率高，可频繁切换
    * 6.多进程更稳定更安全，一个进程死亡不会影响其他金成功（进程有其自己独立的地址空间），
    * 多线程不易维护，一个线程死亡，整个进程就死亡（线程共享一个地址空间)*/
}

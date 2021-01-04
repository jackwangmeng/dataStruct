package com.wm.dataStruct;

import java.util.Arrays;
import java.util.Random;

public class MinHeapTest {
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

        // 构建一个数组，这是归并排序的缺点，需要额外空间
        Integer[] temp = new Integer[n];

        int f = 0;
        int s = 0;

        int i = 0;

        while (i != n && f <= n && s <= n) {
            if (first[f] < second[s]) {
                temp[i++] = first[f++];
            } else {
                temp[i++] = second[s++];
            }
        }

        return temp;

    }
    public static void main(String[] args) {
        //https://blog.csdn.net/never_cxb/article/details/50210317
        Random r = new Random();

        int rowSize = 20;
        int columnSize = 500;

        // 注意 java 二维数组其实是一维数组，里面包含的也是一维数组
        Integer[][] data = new Integer[rowSize][columnSize];

        for (int ii = 0; ii < rowSize; ii++) {
            for (int i = 0; i < columnSize; i++) {
                data[ii][i] = r.nextInt(1600);
            }

            // 将500个元素排序，升序
            Arrays.sort(data[ii]);
            // System.out.println(Arrays.toString(data[ii]));
        }

        // 方法1，直接将20个数组合并，排序，然后取前500个
        // 复杂度是 10000log(10000)
        Integer[] allData = new Integer[20 * 500];
        int a = 0;
        for (int ii = 0; ii < rowSize; ii++) {
            for (int i = 0; i < columnSize; i++) {
                allData[a++] = data[ii][i];
            }
        }
        Arrays.sort(allData);
        Integer[] result1 = Arrays.copyOfRange(allData, 0, columnSize);
        System.out.println("method 1 result:        " + Arrays.toString(result1));

        // 方法2，归并，先归并前两个数组，取前500个数据。将得到的结果再与第3个归并，重复
        // 考虑一下,20个数组先两两归并，得到10个；10个再两两归并，得到5个。等等，直到最后1个
        // 但这样归并的次数和从前往后两两归并的次数是一样的？所以还是 上述的从前往后好了
        // 复杂度是 19*500
        Integer[] result2 = data[0];
        for (int i = 1; i < rowSize; i++) {
            result2 = merge(result2, data[i], columnSize);
        }

        System.out.println("method 2 result:        " + Arrays.toString(result2));

        System.out.println("result1 equals result2: " + Arrays.equals(result1, result2));

        // 方法3，保持一个最小堆，这个堆存放来自20个数组的最小数
        // 每次取出一个数，然后将该数所在的数组的后面一个数入堆
        // 重复上面步骤，取出500个数
        // 注意建堆的时候需要保持 数来自哪个数组，用一个内部类实现
        // 复杂度是 500 * log(20)
        Integer[] result3 = new Integer[500];
        MinHeap<DataWithSource> heap = new MinHeap<DataWithSource>();
        for (int i = 0; i < rowSize; i++) {
            // 记录下来源那个数组，以及在数组中的 index
            DataWithSource d = new DataWithSource(data[i][0], i, 0);
            ((MinHeap<DataWithSource>) heap).add(d);
        }

        int num = 0;
        while (num < columnSize) {
            // 删除顶点元素
            DataWithSource d = heap.removeTop();
            result3[num++] = d.getValue();

            // 将 value 置为该数原数组里的下一个数
            d.setValue(data[d.getComeFrom()][d.getIndex() + 1]);

            // 将其在数组中的 index +1
            d.setIndex(d.getIndex() + 1);
            heap.add(d);
        }

        System.out.println("method 3 result:        " + Arrays.toString(result3));

        System.out.println("result2 equals result3: " + Arrays.equals(result2, result3));


    }

}

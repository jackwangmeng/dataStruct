package com.wm.dataStruct;

import java.util.ArrayList;

/**
 *
 * 最小堆和堆排序, 最小堆，顶点的元素是最小值， 根据《Java 语言程序设计 进阶篇》 p83 改写， 书上是最大堆. 堆排序
 * 将元素都存入最小堆中，从最小堆里面每次取出顶点元素
 *
 * @author tomchen
 *
 * @param <E>
 */
class MinHeap<E extends Comparable> {

    public static <E extends Comparable> void heapSort(E[] array) {
        MinHeap<E> heap = new MinHeap<E>();
        for (int i = 0; i < array.length; i++) {
            heap.add(array[i]);
        }

        System.out.println("Debug: heap is     " + heap);

        for (int i = 0; i < array.length; i++) {
            array[i] = heap.removeTop();
        }
    }

    private ArrayList<E> data = new ArrayList<E>();

    public MinHeap() {
    }

    /**
     * 增加一个新元素，步骤是 1. 先把元素插入到 list 的末尾 2. 比较末尾元素和它的父元素，若小于，交换两者 3.
     * 重复上述步骤，直到到顶点位置或者子元素大于父元素 4. 不一定要遍历堆所有的元素，达到堆的性质后会提前结束
     *
     * @param array
     */
    public void add(E array) {

        data.add(array);

        int child = data.size() - 1;
        int parent = (child - 1) / 2;

        // 判断是否到达顶点
        while (child > 0) {
            // 父元素大于子元素，交换，保持父是小的
            if (data.get(parent).compareTo(array) > 0) {
                data.set(child, data.get(parent));
                data.set(parent, array);

                child = parent;
                parent = (child - 1) / 2;
            } else {
                // 已经是最小堆了，无需再比较
                break;
            }
        }
    }

    /**
     * 删除顶点处的元素，步骤是： 1. 把末尾的元素复制到顶点处 2. 然后比较此时顶点的值和左右子树，保持最小堆的性质 3.
     * 交换顶点和左右子树较小的值 4. 重复上述步骤，直到已经成了最小堆或者遍历完 5. 注意可能存在左子树存在，右子树不存在情况 6.
     * 不一定要遍历堆所有的元素，达到堆的性质后会提前结束
     *
     * @return 返回被删除的元素
     */
    public E removeTop() {
        if (data.isEmpty())
            return null;

        E removed = data.get(0);

        // 因为一直交换的是最后的元素，这儿将其保存
        E last = data.get(data.size() - 1);
        data.set(0, last);
        data.remove(data.size() - 1);

        int parent = 0;
        int leftChild = parent * 2 + 1;
        int rightChild = parent * 2 + 2;

        while (leftChild <= data.size() - 1) {

            int minIndex = leftChild;
            // 右子树存在，判断左右子树哪个小，保存坐标
            // 如果不存在，那么使用左子树的坐标
            // 保存较小元素的坐标，可以省去考虑左右子树都存在，只有左存在的情况
            if (rightChild <= data.size() - 1) {
                if (data.get(rightChild).compareTo(data.get(leftChild)) < 0) {
                    minIndex = rightChild;
                }
            }

            if (data.get(minIndex).compareTo(last) < 0) {
                data.set(parent, data.get(minIndex));
                data.set(minIndex, last);
                parent = minIndex;
                leftChild = parent * 2 + 1;
                rightChild = parent * 2 + 2;
            } else {
                break; // 已经达到了最小堆的性质
            }
        }

        return removed;
    }

    @Override
    public String toString() {
        return data.toString();
    }

}


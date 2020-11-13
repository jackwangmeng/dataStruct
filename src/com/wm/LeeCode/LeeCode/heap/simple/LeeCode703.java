package com.wm.LeeCode.LeeCode.heap.simple;

import java.util.PriorityQueue;

/**
 * @author wm
 * @Package com.wm.LeeCode.LeeCode.heap
 * @date 2020/11/10 17:12
 */
public class LeeCode703 {
    public class KthLargest{
        private PriorityQueue<Integer> queue;
        private int limit;

        public KthLargest(int k, int[] nums){
            limit = k;
            queue = new PriorityQueue<>(k);
            for (int num : nums){
                add(num);
            }
        }

        public int add(int val) {
            if(queue.size() < limit){
                queue.add(val);
            }else if (val > queue.peek()){
                queue.poll();
                queue.add(val);
            }
            return queue.peek();
        }
    }
}

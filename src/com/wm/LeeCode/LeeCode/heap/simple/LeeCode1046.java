package com.wm.LeeCode.LeeCode.heap.simple;

import java.util.*;

/**
 * @author wm
 * @Package com.wm.LeeCode.LeeCode.heap.simple
 * @date 2020/11/10 17:40
 */
public class LeeCode1046 {
    public int lastStoneWeight(int[] stones) {
        /*PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((o1, o2) -> (o2 - o1));
        for (int i = 0; i < stones.length; i++){
            priorityQueue.offer(stones[i]);
        }

        while(priorityQueue.size() > 1){
            int y = priorityQueue.poll();
            int x = priorityQueue.poll();

            int diff = y - x;
            if (diff != 0){
                priorityQueue.offer(diff);
            }
        }
        if(priorityQueue.size() == 0){
            return 0;
        }
        return priorityQueue.peek();*/

        Stack<Integer> stack = new Stack<>();
        Arrays.sort(stones);
        List<Integer> list = new ArrayList<>();
        for (Integer i : stones){
            list.add(i);
            stack.push(i);
        }

        while (stack.size() > 1){
            int y = stack.pop();
            list.remove(list.size()-1);
            int x = stack.pop();
            list.remove(list.size() - 1);
            int diff = y - x;
            if(diff != 0){
                list.add(diff);
            }
            int[] temp = new int[list.size()];
            for (int i = 0;i < list.size(); i++){
                temp[i] = list.get(i);
            }
            lastStoneWeight(temp);
        }
        if (list.size() == 0)
            return 0;
        return list.get(0);
    }

    public static void main(String[] args) {
        int[] nums = {3,7,8};
        System.out.println(new LeeCode1046().lastStoneWeight(nums));
    }
}

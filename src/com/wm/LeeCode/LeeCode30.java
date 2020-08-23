package com.wm.LeeCode;

import javafx.scene.layout.Priority;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LeeCode30 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists==null || lists.length==0) {
            return null;
        }
        //创建一个堆，并设置元素的排序方式
        PriorityQueue<ListNode> queue = new PriorityQueue(new Comparator<ListNode>() {
            public int compare(ListNode o1,ListNode o2){
                return (o1.val - o2.val);
            }
        });

        /*for (int i = 0; i < lists.length; i++){
            while (lists[i] != null){
                queue.add(lists[i]);
                lists[i] = lists[i].next;
            }
        }*/
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        /*while(!queue.isEmpty()){
            dummy.next = queue.poll();
            dummy = dummy.next;
        }
        dummy.next = null;
        return head.next;*/
        for (int i = 0; i < lists.length; i++){
            ListNode head = lists[i];
            if (head != null){
                queue.add(head);
            }
        }

        while (queue.size() > 0){
            ListNode node = queue.poll();
            cur.next = node;
            cur = cur.next;
            if (node.next != null){
                queue.add(node.next);
            }
        }
        cur.next = null;
        return dummy.next;
    }
}

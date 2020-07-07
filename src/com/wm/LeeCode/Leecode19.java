package com.wm.LeeCode;

public class Leecode19 {
    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            /*ListNode pre = new ListNode(0);
            pre.next = head;
            ListNode start = pre,end = pre;
            while (n != 0){
                start = start.next;
                n--;
            }
            while (start.next != null){
                start = start.next;
                end = end.next;
            }
            end.next = end.next.next;
            return end.next;*/
            ListNode node = new ListNode(0);
            node.next = head;
            int len = 0;
            ListNode p = head;
            while (p != null){
                len++;
                p = p.next;
            }

            len -= n;
            p = node;
            for (int i = 0; i < len; i++){
                p = p.next;
            }
            p.next = p.next.next;
            return p.next;
        }
    }


      public class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; }
      }
}

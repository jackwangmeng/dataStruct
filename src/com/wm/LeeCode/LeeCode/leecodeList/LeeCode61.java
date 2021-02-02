package com.wm.LeeCode.LeeCode.leecodeList;

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
/**
 * @author wm
 * @Package com.wm.LeeCode.LeeCode.leecodeList
 * @date 2021/2/2 13:46
 */
public class LeeCode61 {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        ListNode old_tail = head;
        int n;
        for (n = 1; old_tail.next != null; n++) {
            old_tail = old_tail.next;
        }
        old_tail.next = head; //形成闭环


        ListNode new_tail = head;
        for (int i = 0; i < n - k%n - 1; i++) {
            new_tail = new_tail.next;
        }
        ListNode new_head = new_tail.next;
        new_tail.next = null;
        return new_head;
    }
}

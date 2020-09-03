package com.wm.leecode.LeeCode;

/**
 * @author wm
 * @Package com.wm.leecode.LeeCode
 * @date 2020/7/21 8:42
 */
public class LeeCode25 {
    public ListNode reverseKGroup(ListNode head , int k){
        ListNode dummy = new ListNode(0);
        dummy.next = head;  // dummy -> 1 -> 2 -> 3;
        ListNode pre = dummy;
        ListNode end = dummy;

        while( end.next != null){
            for (int i = 0 ; i < k && end != null ; i++){
                end = end.next;
            }
            if (end == null){
                break;
            }
            ListNode next = end.next;
            end.next = null;
            ListNode start = pre.next;
            pre.next = reverse(start);
            start.next = next;
            pre = start;
            end = start;
        }
        return dummy.next;
    }

    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode preNode = null;
        ListNode curNode = head;
        ListNode nextNode = null;
        while (curNode != null){
            nextNode = curNode.next;
            curNode.next = preNode;
            preNode = curNode;
            curNode = nextNode;
        }
        return preNode;
    }
}

package com.wm.LeeCode.LeeCode.nosroted;

/**
 * @author 王萌
 * @version V2.0
 * @Package com.wm.leecode
 * @date 2020/7/20 8:48
 * @Copyright © 2020- 北京建设数字科技股份有限公司
 */

public class LeeCode24 {
    public ListNode swapPairs(ListNode head) {
        /*if ( (head == null) || (head.next == null) ){
            return head;
        }

        ListNode firstNode = head;
        ListNode secondNode = head.next;

        firstNode.next = swapPairs(secondNode.next);
        secondNode.next = firstNode;
        return secondNode;
    }*/
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prevNode = dummy;

        while ((head != null) && (head.next != null)) {
            ListNode firstNode = head;
            ListNode secondNode = head.next;

            prevNode.next = secondNode;
            firstNode.next = secondNode.next;
            secondNode.next = firstNode;

            prevNode = firstNode;
            head = firstNode.next;
        }
        return dummy.next;
    }
}

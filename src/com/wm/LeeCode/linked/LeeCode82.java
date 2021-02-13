package com.wm.LeeCode.linked;
public class LeeCode82 {
    public ListNode deleteDuplicates(ListNode head) {
        /*
        //创建一个头结点指向head
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        //创建一个节点指向当前头结点，以及一个后继节点指向当前head
        ListNode prev = dummyHead;
        ListNode cur = prev.next;

        while (cur != null) {
            int curNum = 0;
            ListNode difNode = cur;
            while (difNode != null && difNode.val == cur.val) {
                ++curNum;
                difNode = difNode.next;
            }
            if (curNum > 1) {
                prev.next = difNode;
            } else {
                prev = cur;
            }
            cur = difNode;
        }
        return dummyHead.next;
        */
        //1.头节点为null或头节点下一节点为null，直接返回头节点，这时不存在重复节点
        /*if (head == null || head.next == null) {
            return head;
        }
        if (head.val == head.next.val) {
            while (head != null && head.next != null && head.val == head.next.val) {
                head = head.next;
            }
            return deleteDuplicates(head.next);
        } else {
            head.next = deleteDuplicates(head.next);
            return head;
        }*/

        if (head == null || head.next == null) return head;
        int tempVal = head.val;//2.缓存当前这层的节点的元素,用来进行等值判断
        if (tempVal == head.next.val) {//3.如果当前节点与下一个节点元素相等,说明这是个重复元素,就开始进行删除操作
            while (head != null && tempVal == head.val) {//4.从当前节点开始删除, 即, 使当前节点等于下一个节点
                head = head.next;
            }
            return deleteDuplicates(head);
        } else {//5.如果当前节点与下一个节点元素不等,则对下一个节点之后的节点进行判断
            head.next = deleteDuplicates(head.next);
            return head;
        }
    }
}

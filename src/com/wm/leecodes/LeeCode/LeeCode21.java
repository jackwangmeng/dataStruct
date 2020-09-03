package com.wm.leecodes.LeeCode;

/**
 * @author 王萌
 * @version V2.0
 * @Package com.wm.leecode
 * @date 2020/7/8 16:25
 * @Copyright © 2020- 北京建设数字科技股份有限公司
 */


public class LeeCode21 {


    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null){
            return l2;
        }else if (l2 == null){
            return l1;
        }else if (l1.val <= l2.val){
            l1.next = mergeTwoLists(l1.next,l2);
            return l1;
        }
        else {
            l2.next = mergeTwoLists(l1,l2.next);
            return l2;
        }
    }
}

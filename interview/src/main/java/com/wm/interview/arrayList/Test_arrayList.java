package com.wm.interview.arrayList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author wm
 * @Package com.wm.interview.arrayList
 * @date 2021/2/1 12:18
 */
public class Test_arrayList {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(Collections.nCopies(8, "0"));
        int s = "a".hashCode();
        list.set("a".hashCode() & 8 - 1, "a");
        list.set("b".hashCode() & 8 - 1, "b");
        list.set("c".hashCode() & 8 - 1, "c");
        list.set("d".hashCode() & 8 - 1, "d");
        list.set("e".hashCode() & 8 - 1, "e");
        list.set("f".hashCode() & 8 - 1, "f");
        list.set("g".hashCode() & 8 - 1, "g");

        System.out.println("元素集合：" + list);
        System.out.println("获取元素 f [\"f\".hashCode() & 8 - 1)] Idx： " + ("f".hashCode() & (8 - 1)) + " 元素：" + list.get("f".hashCode() & 8 - 1));
        System.out.println("获取元素 e [\"e\".hashCode() & 8 - 1)] Idx： " + ("e".hashCode() & (8 - 1)) + " 元素：" + list.get("e".hashCode() & 8 - 1));
        System.out.println("获取元素 d [\"d\".hashCode() & 8 - 1)] Idx： " + ("d".hashCode() & (8 - 1)) + " 元素：" + list.get("d".hashCode() & 8 - 1));
    }
}

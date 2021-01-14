package com.wm.interviewing.javaSE.serializable;

/**
 * @author wm
 * @Package com.wm.interviewing.javaSE.serializable
 * @date 2021/1/14 17:31
 */
public class CloneTest {
    public static void main(String[] args) {
        try {
            Person p1 = new Person("wm", 23, new Car("ben", 300));
            Person p2 = MyUtil.clone(p1);
            p2.getCar().setBrand("BYD");
            System.out.println(p1);
            System.out.println(p2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

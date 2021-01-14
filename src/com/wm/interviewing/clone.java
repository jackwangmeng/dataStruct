package com.wm.interviewing;

import com.wm.interviewing.javaSE.Person;

import java.util.Calendar;

/**
 * @author wm
 * @Package com.wm.interviewing.javaSE
 * @date 2021/1/14 12:19
 */
public class clone {
    public static void main(String[] args) throws CloneNotSupportedException {
        Person p = new Person(23, "wang");
        Person p1 = p;
        System.out.println(p);
        System.out.println(p1);

        Person pClone = (Person) p.clone();
        System.out.println(pClone);
        String result = p.getName() == pClone.getName() ? "clone是浅拷贝的" : "clone是深拷贝的";
        System.out.println(result);

        Calendar cal = Calendar.getInstance();

    }
}

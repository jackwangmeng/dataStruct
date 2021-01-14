package com.wm.interviewing.javaSE;

/**
 * @author wm
 * @Package com.wm.interviewing.javaSE.javaSE
 * @date 2021/1/14 12:20
 */
public class Person implements Cloneable{
    private int age ;
    private String name;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public Person() {}

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return (Person)super.clone();
    }
}

package com.wm.programming;

public class TempTest {
    /*private void test1(int a){
        a = 5;
        System.out.println("test1方法中的a="+a);
    }

    public static void main(String[] args) {
        TempTest t = new TempTest();
        int a = 3;
        t.test1(a);
        System.out.println("main方法中的a="+a);
    }*/
    static class A{
        public int age = 0;
    }
    private void test1(A a){
        a.age = 20;
        System.out.println("test1方法中的age="+a.age);
    }

    public static void main(String[] args) {
        TempTest t = new TempTest();
        A a = new A();
        a.age = 10;
        t.test1(a);
        System.out.println("main方法中的age="+a.age);
    }
}

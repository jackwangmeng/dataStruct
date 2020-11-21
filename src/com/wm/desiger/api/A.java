package com.wm.desiger.api;

public class A {

    int m ;
    public A(){
        System.out.println("This is A:");
    }
    public A(Integer m){
        System.out.println("this is " + m);
    }

    private void func1(String s, Integer m){
        System.out.println(s + ":" + m);
    }
    public void func2(){}

}

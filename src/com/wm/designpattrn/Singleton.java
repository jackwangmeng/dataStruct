package com.wm.designpattrn;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader;

public class Singleton {

    /*线程安全*/
    /*private static final Singleton singleton_safe = new Singleton();
    private Singleton(){

    }

    public static Singleton getSingleton_safe(){
        return singleton_safe;
    }

    public static void doSomeThing(){
    }*/

    /*线程不安全*/
    private static Singleton singleton_NotSafe = null;

    //限制产生多个对象
    private Singleton(){
    }

    //通过产生该方法获取实例对象
    public static Singleton getInstance(){
        if(singleton_NotSafe == null){
            singleton_NotSafe = new Singleton();
        }
        return singleton_NotSafe;
    }
}

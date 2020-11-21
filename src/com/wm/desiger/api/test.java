package com.wm.desiger.api;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class test {

    public static void main(String[] args) throws Exception {
        //加载并初始化指定的类A
        Class classInfo = Class.forName("com.wm.desiger.api.A");

        //获得类的构造函数
        System.out.println("类A构造函数如下所示：");
        Constructor cons[] = classInfo.getConstructors();
        for (int i = 0; i < cons.length; i++){
            System.out.println(cons[i].toString());
        }

        //获得类的所有变量
        System.out.println();
        System.out.println("类A变量如下所示：");

        Field fields[] = classInfo.getDeclaredFields();
        for (Field field : fields){
            System.out.println(fields.toString());
        }

        //获取类的所有方法
        System.out.println();
        System.out.println("类A方法如下所示： ");
        Method[] methods = classInfo.getDeclaredMethods();
        for (Method method : methods){
            System.out.println(methods.toString());
        }

        //number 1
        Constructor[] constructors = classInfo.getConstructors();

        //调用无参构造函数
        constructors[2].newInstance();
        //调用一个参数构造方法
        constructors[1].newInstance(new Object[]{10});
        //调用2个参数构造函数
        constructors[0].newInstance(new Object[]{"Hello",2010});

        //number 2
        System.out.println("\n\n\n");
        //调用无参构造函数
        Constructor c = classInfo.getConstructor();
        c.newInstance();

        //调用1个参数构造方法
        c = classInfo.getConstructor(new Class[]{Integer.class});
        c.newInstance(new Object[]{10});

        //调用2个参数构造方法
        c = classInfo.getConstructor(new Class[]{String.class,Integer.class});
        c.newInstance(new Object[]{"Hello",2010});
    }
}

package com.wm.desiger.proxy.test;

import com.wm.desiger.proxy.IUserDao;
import com.wm.desiger.proxy.cglib.CglibProxyFactory;
import com.wm.desiger.proxy.dao.UserDao;
import com.wm.desiger.proxy.dao.impl.ProxyFactory;
import org.junit.Test;

public class TestProxy {

    @Test
    public void testDynamicProxy() {
        IUserDao target = new UserDao();
        System.out.println(target.getClass());
        IUserDao proxy = (IUserDao) new ProxyFactory(target).getProxyInstance();
        System.out.println(proxy.getClass());
        proxy.save();
    }

    @Test
    public void testCglibProxy() {
        //目标对象
        com.wm.desiger.proxy.cglib.UserDao target = new com.wm.desiger.proxy.cglib.UserDao();
        System.out.println(target.getClass());
        com.wm.desiger.proxy.cglib.UserDao proxy = (com.wm.desiger.proxy.cglib.UserDao) new CglibProxyFactory(target).getProxyInstance();
        System.out.println(proxy.getClass());
        proxy.save();
    }
}

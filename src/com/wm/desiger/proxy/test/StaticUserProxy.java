package com.wm.desiger.proxy.test;

import com.wm.desiger.proxy.IUserDao;
import com.wm.desiger.proxy.dao.UserDao;
import com.wm.desiger.proxy.dao.impl.UserDaoProxy;
import org.junit.Test;

public class StaticUserProxy {

    @Test
    public void testStaticProxy() {
        //目标对象
        IUserDao target = new UserDao();
        //代理对象
        UserDaoProxy proxy = new UserDaoProxy(target);
        proxy.save();
    }
}

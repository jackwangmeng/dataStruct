package com.wm.desiger.proxy.dao;

import com.wm.desiger.proxy.IUserDao;

public class UserDao implements IUserDao {

    @Override
    public void save() {
        System.out.println("保存数据");
    }
}

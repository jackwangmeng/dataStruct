package com.wm.jwt.jwt.dao;

import com.wm.jwt.jwt.pojo.User;

/**
 * @author wm
 * @Package com.wm.jwt.jwt.dao
 * @date 2021/3/10 11:31
 */
public interface UserDao {
    User queryByName(String name);
}

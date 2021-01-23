package com.wm.mysqlconnector.service;

import com.wm.mysqlconnector.entity.User;

/**
 * @author wm
 * @Package com.wm.mysqlconnector.service
 * @date 2021/1/19 10:24
 */
public interface UserService {
    User save(User user);

    void delete(int id);

    User get(Integer id);
}

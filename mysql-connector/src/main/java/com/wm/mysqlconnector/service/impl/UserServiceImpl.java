package com.wm.mysqlconnector.service.impl;

import com.wm.mysqlconnector.entity.User;
import com.wm.mysqlconnector.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wm
 * @Package com.wm.mysqlconnector.service.impl
 * @date 2021/1/19 10:25
 */
@Service
public class UserServiceImpl implements UserService {

    private static Logger logger = LogManager.getLogger(UserServiceImpl.class);

    private static Map<Integer, User> userMap = new HashMap<>();

    static {
        userMap.put(1, new User(1, "张三", 25));
        userMap.put(2, new User(2, "李四", 26));
        userMap.put(3, new User(3, "王二", 22));
    }

    @CachePut(value = "user", key = "#user.id")
    @Override
    public User save(User user) {
        userMap.put(user.getId(), user);
        logger.info("进入save方法，当前存储对象：{}", user.toString());
        return user;
    }

    @CacheEvict(value = "user", key = "#id")
    @Override
    public void delete(int id) {
        userMap.remove(id);
        logger.info("进入delete方法，删除成功");
    }

    @Cacheable(value = "user", key = "#id")
    @Override
    public User get(Integer id) {
        logger.info("进入get方法，当前获取对象：{}", userMap.get(id) == null ? null : userMap.get(id));
        return userMap.get(id);
    }
}

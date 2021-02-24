package com.wm.mysqlconnector.service.impl;

import org.springframework.stereotype.Service;

/**
 * @author wm
 * @Package com.wm.mysqlconnector.service.impl
 * @date 2021/2/23 16:08
 */
@Service
public class IAopService {

    public String test1(String param) {
        System.out.println("我是test1");
        return "test1";
    }

    public String test2(String param) {
        System.out.println("我是test2");
        return "test2";
    }

    public String test3(String param) {
        System.out.println("我是test3");
        return "test3";
    }
}

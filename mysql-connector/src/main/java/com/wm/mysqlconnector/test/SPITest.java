package com.wm.mysqlconnector.test;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @author wm
 * @Package com.wm.mysqlconnector.test
 * @date 2021/1/29 15:15
 */
public class SPITest {
    public static void main(String[] args) {
        ServiceLoader<Aobing> serviceLoader = ServiceLoader.load(Aobing.class);
        Iterator<Aobing> iterator = serviceLoader.iterator();
        while (iterator.hasNext()) {
            Aobing aobing = iterator.next();
            aobing.say();
        }
    }
}

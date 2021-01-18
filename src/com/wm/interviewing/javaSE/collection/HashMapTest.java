package com.wm.interviewing.javaSE.collection;

import java.net.Inet4Address;
import java.security.KeyStore;
import java.util.*;

/**
 * @author wm
 * @Package com.wm.interviewing.javaSE.collection
 * @date 2021/1/15 14:15
 */
public class HashMapTest {
    public static void main(String[] args) {
        HashMap<Integer, com.wm.javaCode.HashMapTest.User> users = new HashMap<>();
        users.put(1, new com.wm.javaCode.HashMapTest.User("张三", 25));
        users.put(2, new com.wm.javaCode.HashMapTest.User("lisi", 26));
        users.put(3, new com.wm.javaCode.HashMapTest.User("wangwu", 43));
        System.out.println(users);
        HashMap<Integer, com.wm.javaCode.HashMapTest.User> sortHashMap = sortHashMap(users);
        System.out.println(sortHashMap);

    }

    private static HashMap<Integer,com.wm.javaCode.HashMapTest.User> sortHashMap(HashMap<Integer,com.wm.javaCode.HashMapTest.User> users) {
        //拿到users的键值对集合
        Set<Map.Entry<Integer, com.wm.javaCode.HashMapTest.User>> entrySet = users.entrySet();

        //将set集合转化为List集合
        List<Map.Entry<Integer, com.wm.javaCode.HashMapTest.User>> list = new ArrayList<>(entrySet);
        Collections.sort(list, new Comparator<Map.Entry<Integer, com.wm.javaCode.HashMapTest.User>>() {
            @Override
            public int compare(Map.Entry<Integer, com.wm.javaCode.HashMapTest.User> o1, Map.Entry<Integer, com.wm.javaCode.HashMapTest.User> o2) {
                return o2.getValue().getAge() - o1.getValue().getAge();
            }
        });

        //创建一个新的有序的HashMap子类的集合
        LinkedHashMap<Integer, com.wm.javaCode.HashMapTest.User> linkedHashMap = new LinkedHashMap<>();
        for (Map.Entry<Integer, com.wm.javaCode.HashMapTest.User> entry : list) {
            linkedHashMap.put(entry.getKey(), entry.getValue());
        }
        return linkedHashMap;
    }
}

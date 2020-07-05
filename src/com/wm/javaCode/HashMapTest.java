package com.wm.javaCode;

import com.wm.IO.T;
import sun.awt.datatransfer.DataTransferer;

import javax.jws.soap.SOAPBinding;
import java.io.Serializable;
import java.util.*;

public class HashMapTest {
    public static void main(String[] args) {
        HashMap<Integer,User> users = new HashMap<Integer, User>();
        users.put(1,new User("张三",25));
        users.put(2,new User("李四",22));
        users.put(3,new User("王五",28));
        System.out.println(users);
        HashMap<Integer,User> sortHashMap = sortHashMap(users);
        System.out.println(sortHashMap);
    }

    private static HashMap<Integer, User> sortHashMap(HashMap<Integer, User> map) {
        Set<Map.Entry<Integer,User>> entrySet = map.entrySet();

        List<Map.Entry<Integer,User>> list = new ArrayList<Map.Entry<Integer,User>>(entrySet);
        Collections.sort(list,new Comparator<Map.Entry<Integer,User>>(){
            @Override
            public int compare(Map.Entry<Integer, User> o1, Map.Entry<Integer, User> o2) {
                return o2.getValue().getAge() - o1.getValue().getAge();
            }
        });

        LinkedHashMap<Integer, User> linkedHashMap = new LinkedHashMap<Integer, User>();
        for (Map.Entry<Integer,User> entry : list){
            linkedHashMap.put(entry.getKey(),entry.getValue());
        }
        return linkedHashMap;
    }

    public static class User implements Serializable {
        private String name;
        private int age;

        public User(String name,int age){
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }
}

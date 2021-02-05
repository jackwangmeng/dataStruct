package com.wm.interview.hashMap;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wm
 * @Package com.wm.interview.hashMap
 * @date 2021/1/28 11:44
 */
public class ApiTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("jlkk");
        list.add("lopi");
        list.add("表我们");
        list.add("e4we");
        list.add("alpo");
        list.add("yhjk");
        list.add("plop");

        //定义要存放的数据
        String[] tab = new String[8];

        //循环存放
        for (String key : list) {
            int index = key.hashCode() & (tab.length - 1); //计算索引位置
            System.out.println(String.format("key值=%s Index=%d", key, index));
            if (tab[index] == null) {
                tab[index] = key;
                continue;
            }
            tab[index] = tab[index] + " -> " + key;
        }
        System.out.println(JSON.toJSONString(tab));
    }
}

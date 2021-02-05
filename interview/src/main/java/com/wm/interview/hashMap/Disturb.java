package com.wm.interview.hashMap;

/**
 * @author wm
 * @Package com.wm.interview.hashMap
 * @date 2021/1/28 14:01
 */
public class Disturb {

    //扰动函数下，下标值计算
    public static int disturbHashIndex(String key, int size) {
        return (size - 1) & (key.hashCode() ^ (key.hashCode() >>> 16));
    }

    //非扰动函数下，下标值的计算
    public static int hashIndex(String key, int size) {
        return (size - 1) & key.hashCode();
    }
}

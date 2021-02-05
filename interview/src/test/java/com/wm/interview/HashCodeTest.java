package com.wm.interview;

import com.wm.interview.hashCode.FileUtile;
import com.wm.interview.hashCode.HashCode;
import com.wm.interview.hashCode.RateInfo;
import com.wm.interview.hashMap.Disturb;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

/**
 * @author wm
 * @Package com.wm.interview
 * @date 2021/1/28 11:17
 */
public class HashCodeTest {

    private Set<String> words;

    @Before
    public void before() {
        "abc".hashCode();
        words = FileUtile.readWordList("H:\\learning\\literarynotes\\interview\\src\\main\\resources\\interview-master\\interview-master\\interview-03\\103976个英语单词库.txt");
    }

    @Test
    public void test_collisionRate() {
        System.out.println("单词数量：" + words.size());
        HashCode hashCode = new HashCode();
        List<RateInfo> rateInfoList = HashCode.collisionRateList(words,2,3,5,7,17,31,32,33,39,41,199 );
        for (RateInfo rate : rateInfoList) {
            System.out.println(String.format("乘数 = %4d, 最小Hash = %11d, 最大Hash = %10d, 碰撞数量 =%6d, 碰撞概率 = %.4f%%", rate.getMultiplier(), rate.getMinHash(), rate.getMaxHash(), rate.getCollisionCount(), rate.getCollisionRate() * 100));
        }
    }

    @Test
    public void test_hashArea() {
        System.out.println(HashCode.hashArea(words, 2).values());
        System.out.println(HashCode.hashArea(words, 7).values());
        System.out.println(HashCode.hashArea(words, 31).values());
        System.out.println(HashCode.hashArea(words, 32).values());
        System.out.println(HashCode.hashArea(words, 199).values());
    }

    @Test
    public void test_disturb() {
        Map<Integer, Integer> map = new HashMap<>(16);

        for (String word : words) {
            //使用扰动函数
            int index = Disturb.disturbHashIndex(word, 128);
            //不适用扰动函数
            if (map.containsKey(index)) {
                Integer integer = map.get(index);
                map.put(index, ++integer);
            } else {
                map.put(index, 1);
            }
        }
        System.out.println(map.values());
    }

    @Test
    public void test_threshhold() {
        System.out.println(tableSizeFor(17));
    }

    private int tableSizeFor(int cap) {
        int n = cap - 1;
        System.out.println(Integer.toBinaryString(n));
        n |= n >>> 1;
        System.out.println(Integer.toBinaryString(n));
        n |= n >>> 2;
        System.out.println(Integer.toBinaryString(n));
        n |= n >>> 4;
        System.out.println(Integer.toBinaryString(n));
        n |= n >>> 8;
        System.out.println(Integer.toBinaryString(n));
        n |= n >>> 16;
        System.out.println(Integer.toBinaryString(n));
        return (n < 0) ? 1 : (n >= (1 << 30)) ? (1 << 30) : n + 1;
    }

    @Test
    public void test_hashMapSize() {
        Map<Integer, Integer> map = new HashMap<>(17);
        System.out.println(map.keySet().size());
    }

    @Test
    public void test_hashMap() {
        List<String> list = new ArrayList<>();
        list.add("jlkk");
        list.add("lopi");
        list.add("jmdw");
        list.add("e4we");
        list.add("io98");
        list.add("nmhg");
        list.add("vfg6");
        list.add("gfrt");
        list.add("alpo");
        list.add("vfbh");
        list.add("bnhj");
        list.add("zuio");
        list.add("iu8e");
        list.add("yhjk");
        list.add("plop");
        list.add("dd0p");

        for (String key : list) {
            int hash = key.hashCode() ^ (key.hashCode() >>> 16);
            System.out.println("字符串：" + key + " \tIdx(16)：" + ((16 - 1) & hash) + " \tBit值：" + Integer.toBinaryString(hash) + " - " + Integer.toBinaryString(hash & 16) + " \t\tIdx(32)：" + ((32 - 1) & hash));
            System.out.println(Integer.toBinaryString(key.hashCode()) +" "+ Integer.toBinaryString(hash) + " " + Integer.toBinaryString((32 - 1) & hash));
        }
    }
}

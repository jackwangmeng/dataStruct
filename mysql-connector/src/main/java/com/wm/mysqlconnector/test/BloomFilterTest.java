package com.wm.mysqlconnector.test;

import com.google.common.base.Charsets;
import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

/**
 * @author wm
 * @Package com.wm.mysqlconnector.test
 * @date 2021/2/4 15:15
 */
public class BloomFilterTest {
    public static void main(String[] args) {
        int total = 1000000;  //总数量

        BloomFilter<CharSequence> bf =
                BloomFilter.create(Funnels.stringFunnel(Charsets.UTF_8), total, 0.0002);

        //初始化1000000条数据到过滤器中
        for (int i = 0; i < total; i++) {
            bf.put("" + i);
        }
        int count = 0;
        for (int i = 0; i < total + 10000; i++) {
            if (bf.mightContain("" + i)) {
                count++;
            }
        }
        System.out.println("已匹配数量：" + count);
    }
}

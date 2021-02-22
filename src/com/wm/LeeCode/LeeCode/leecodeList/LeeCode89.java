package com.wm.LeeCode.LeeCode.leecodeList;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wm
 * @Package com.wm.LeeCode.LeeCode.leecodeList
 * @date 2021/2/22 10:35
 */
public class LeeCode89 {
    public List<Integer> grayCode(int n) {
        /*
        List<Integer> result = new ArrayList<Integer>(){{ add(0); }};

        int head = 1;
        for (int i = 0; i < n; ++i) {
            for (int j = result.size() - 1; j >= 0; --j) {
                result.add(head + result.get(j));
            }
            head = head << 1;
        }
        return result;
        */

        List<Integer> res = new ArrayList<>();
        res.add(0); //初始化第0项
        for (int i = 1; i < 1<<n; ++i) {
            //获取上一项的值
            int prevValue = res.get(i - 1);

            if ((i & 1) == 1) {
                prevValue ^= 1;
                res.add(prevValue);
            } else {
                int temp = prevValue;

                for (int j = 0; j < n; ++j) {
                    if ((temp & 1) == 1) {
                        prevValue ^= 1 << (j + 1);
                        res.add(prevValue);
                        break;
                    }
                    temp >>= 1;
                }
            }
        }
        return res;
    }
}

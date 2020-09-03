package com.wm.leecode.LeeCode;

/**
 * @author wm
 * @Package com.wm.leecode.LeeCode
 * @date 2020/8/26 9:24
 */
public class LeeCode28 {
    public int strStr(String haystack,String needle){
        /*int L = needle.length(),n = haystack.length();
        for (int start = 0; start < n - L + 1; ++start){
            if (haystack.substring(start,start + L).equals(needle)){
                return start;
            }
        }
        return -1;*/
        /*int L = needle.length(), n = haystack.length();
        if (L == 0){
            return 0;
        }
        int pn = 0;
        while (pn < n - L + 1){
            while ((pn < n - L + 1) && (haystack.charAt(pn) != needle.charAt(0))){
                ++pn;
            }
            int currLen = 0,pL = 0;
            while ((pL < L) && (pn < n) && (haystack.charAt(pn) == needle.charAt(pL))){
                ++pn;
                ++pL;
                ++currLen;
            }
            if (currLen == L){
                return pn - L;
            }
            pn = pn - currLen + 1;
        }
        return -1;*/
        int strLen = haystack.length(), subLen = needle.length();
        if (subLen == 0) return 0;
        if (strLen == 0) return -1;
        // 构建状态机
        int[][] FSM = new int[subLen][256];
        int X = 0, match = 0;
        for (int i = 0; i < subLen; i++) {
            match = (int) needle.charAt(i);
            for (int j = 0; j < 256; j++) {
                // 当前状态 + 匹配失败字符 = 孪生词缀状态 + 匹配字符
                FSM[i][j] = FSM[X][j];
            }
            FSM[i][match] = i + 1;
            if (i > 0) {
                // 下一孪生前缀状态 = X + match
                X = FSM[X][match];
            }
        }
        // 匹配子串
        int state = 0;
        for (int i = 0; i < strLen; i++) {
            state = FSM[state][haystack.charAt(i)];
            if (state == subLen) {
                return i - subLen + 1;
            }
        }
        return -1;
    }
}

package com.wm.LeeCode.LeeCode.Thread;

import java.util.*;

/**
 * @author wm
 * @Package com.wm.LeeCode.LeeCode.Thread
 * @date 2021/1/28 16:53
 */
public class LeeCode49 {
    public List<List<String>> groupAnagrams(String[] strs) {
       /*
        Map<String, List<String>> res = new HashMap<>();

        for (String str : strs) {
            char[] ch = str.toCharArray();
            Arrays.sort(ch);
            String key = new String(ch);
            List<String> temp = res.getOrDefault(key, new ArrayList<>());
            temp.add(str);
            res.put(key, temp);
        }
        return new ArrayList<>(res.values());
        */

        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            int[] counts = new int[26];
            int length = str.length();
            for (int i = 0; i < length; i++) {
                counts[str.charAt(i) - 'a']++;
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                if (counts[i] != 0) {
                    sb.append((char) ('a' + i));
                    sb.append(counts[i]);
                }
            }
            String key = sb.toString();
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(new LeeCode49().groupAnagrams(strs));
    }
}

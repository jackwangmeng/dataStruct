package com.wm.interview.hashCode;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/**
 * @author wm
 * @Package com.wm.interview.hashCode
 * @date 2021/1/28 10:07
 */
public class FileUtile {

    /*

    * */
    public static Set<String> readWordList(String url) {
        Set<String> list = new HashSet<>();
        try {
            InputStreamReader isr = new InputStreamReader(new FileInputStream(url));
            BufferedReader br = new BufferedReader(isr);
            String line = "";
            while ((line = br.readLine()) != null) {
                String[] ss = line.split("\t");
                list.add(ss[1]);
            }
            br.close();
            isr.close();
        } catch (Exception e) {
            return null;
        }
        return list;
    }
}

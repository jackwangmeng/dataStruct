package com.wm.interview.jvm.impl;

import com.wm.interview.jvm.classpath.Entry;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author wm
 * @Package com.wm.interview.jvm.impl
 * @date 2021/2/7 16:51
 */
public class CompositeEntry implements Entry {

    private final List<Entry> entryList = new ArrayList<>();

    public CompositeEntry(String pathList) {
        String[] paths = pathList.split(File.pathSeparator);
        for (String str : paths) {
            entryList.add(Entry.create(str));
        }
    }

    @Override
    public byte[] readClass(String className) throws Exception {
        for (Entry entry : entryList) {
            try {
                return entry.readClass(className);
            } catch (Exception e) {

            }
        }
        throw new IOException("class not found " + className);
    }

    @Override
    public String toString() {
        String[] strs = new String[entryList.size()];
        for (int i = 0; i < entryList.size(); ++i) {
            strs[i] = entryList.get(i).toString();
        }
        return String.join(File.pathSeparator, strs);
    }
}

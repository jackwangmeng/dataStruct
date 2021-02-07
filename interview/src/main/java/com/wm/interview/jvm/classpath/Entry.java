package com.wm.interview.jvm.classpath;

import com.wm.interview.jvm.impl.CompositeEntry;
import com.wm.interview.jvm.impl.DirEntry;
import com.wm.interview.jvm.impl.WildcardEntry;

import java.io.File;
import java.util.zip.ZipEntry;

/**
 * @author wm
 * @Package com.wm.interview.jvm
 * @date 2021/2/7 16:29
 */
public interface Entry {

    byte[] readClass(String className) throws Exception;

    static Entry create(String path) {

        //File.pathSeparator : 路径分隔符（win\linux）
        if (path.contains(File.pathSeparator)) {
            return new CompositeEntry(path);
        }
        if (path.endsWith("*")) {
            return new WildcardEntry(path);
        }
        if (path.endsWith(".jar") || path.endsWith("JAR") ||
            path.endsWith(".zip") || path.endsWith(".ZIP")) {
            return (Entry) new ZipEntry(path);
        }
        return new DirEntry(path);
    }
}

package com.wm.interview.jvm.impl;

import com.wm.interview.jvm.classpath.Entry;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author wm
 * @Package com.wm.interview.jvm.impl
 * @date 2021/2/7 16:41
 */
public class DirEntry implements Entry {

    private Path absolutePath;

    public DirEntry(String path) {
        this.absolutePath = Paths.get(path).toAbsolutePath();
    }

    @Override
    public byte[] readClass(String className) throws Exception {
        //目录形式的读取绝对路径下的文件，获取字节码
        return Files.readAllBytes(absolutePath.resolve(className));
    }

    @Override
    public String toString() {
        return this.absolutePath.toString();
    }
}

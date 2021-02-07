package com.wm.interview.jvm.impl;

import com.wm.interview.jvm.classpath.Entry;

import java.nio.file.*;

/**
 * @author wm
 * @Package com.wm.interview.jvm.impl
 * @date 2021/2/7 16:45
 */
public class ZipEntry implements Entry {

    private Path absolutePath;

    public ZipEntry(String path) {
        this.absolutePath = Paths.get(path).toAbsolutePath();
    }

    @Override
    public byte[] readClass(String className) throws Exception {
        try (FileSystem zip = FileSystems.newFileSystem(absolutePath, null)) {
            return Files.readAllBytes(zip.getPath(className));
        }
    }

    @Override
    public String toString() {
        return this.absolutePath.toString();
    }
}

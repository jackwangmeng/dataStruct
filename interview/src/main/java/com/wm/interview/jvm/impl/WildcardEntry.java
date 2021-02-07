package com.wm.interview.jvm.impl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;

/**
 * @author wm
 * @Package com.wm.interview.jvm.impl
 * @date 2021/2/7 17:24
 */
public class WildcardEntry extends CompositeEntry {
    public WildcardEntry(String pathList) {
        super(toPathList(pathList));
    }

    private static String toPathList(String wildCardPath) {
        String baseDir = wildCardPath.replace("*", "");
        try {
            return Files.walk(Paths.get(baseDir))
                    .filter(Files::isRegularFile)
                    .map(Path::toString)
                    .filter(p -> p.endsWith(".jar") || p.endsWith(".JAR"))
                    .collect(Collectors.joining(File.pathSeparator));
        } catch (IOException e) {
            return "";
        }
    }
}

package com.wm.interview.jvm.classpath;

import com.wm.interview.jvm.impl.WildcardEntry;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author wm
 * @Package com.wm.interview.jvm.classpath
 * @date 2021/2/7 17:30
 */
public class ClassPath {

    private Entry bootStrapClasspath;  //启动类路径
    private Entry userClasspath;       //用户类路径
    private Entry extensionClasspath;  //用户类路径

    public ClassPath(String jreOption, String cpOption) {
        //启动类&扩展类"C:\Program Files\Java\jdk1.8.0_121\jre"
        bootstrapAndExtensionClasspath(jreOption);
        //用户类 H:\..\com\wm\interview\test\HelloWorld
        parseUserClasspath(cpOption);
    }

    private void bootstrapAndExtensionClasspath(String jreOption) {
        String jreDir = getJreDir(jreOption);

        //..jre/lib/*
        String jreLibPath = Paths.get(jreDir, "lib") + File.separator + "*";
        bootStrapClasspath = new WildcardEntry(jreLibPath);
        
        //..jre/lib/ext/*
        String jreExtPath = Paths.get(jreDir, "ext") +File.separator + "*";
        extensionClasspath = new WildcardEntry(jreExtPath);
    }

    private String getJreDir(String jreOption) {
        if (jreOption != null && Files.exists(Paths.get(jreOption))) {
            return jreOption;
        }
        if (Files.exists(Paths.get("./jre"))) {
            return "./jre";
        }
        String jh = System.getenv("JAVA_HOME");
        if (jh != null) {
            return Paths.get(jh, "jre").toString();
        }
        throw new RuntimeException("Can not find JRE folder!");
    }

    private void parseUserClasspath(String cpOption) {
        if (cpOption == null) {
            cpOption = ".";
        }
        userClasspath = Entry.create(cpOption);
    }

    public byte[] readClass(String className) throws Exception {
        className = className + ".class";

        //[readClass]启动类路径
        try {
            return bootStrapClasspath.readClass(className);
        } catch (Exception ignored) {
            //ignored
        }

        //[readClass]扩展类路径
        try {
            return extensionClasspath.readClass(className);
        } catch (Exception ignored) {
            //ignored
        }

        //[readClass]用户类路径
        return userClasspath.readClass(className);
    }
}

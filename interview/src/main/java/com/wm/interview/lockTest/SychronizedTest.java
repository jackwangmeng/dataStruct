package com.wm.interview.lockTest;

import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.vm.VM;

public class SychronizedTest {
    public static void main(String[] args) {
        System.out.println(VM.current().details());
        Object obj = new Object();
        System.out.println(obj + "十六进制哈希：" +
                Integer.toHexString(obj.hashCode()));
        System.out.println(ClassLayout.parseInstance(obj).toPrintable());
    }
}

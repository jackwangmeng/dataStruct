package com.wm.dataStruct;

import java.util.Objects;
import java.util.stream.Stream;

public class judgeStrs {
    public static void main(String[] args) {
        String s = Stream.of("123", "", "12312")
                .filter(Objects::nonNull)
                .findFirst()
                .orElse("12");

        System.out.println(s);
    }
}

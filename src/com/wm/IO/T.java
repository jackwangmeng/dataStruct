package com.wm.IO;

import com.sun.org.apache.xpath.internal.operations.String;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class T {
    public static void main(String[] args) throws IOException {
       /* FileReader file = new FileReader(new File("D:\\a.txt"));
        char[] cs = new char[500];
        int len = 0;
        int count = 0;
        while ((len = file.read(cs)) != -1){
            count++;
            System.out.println(new String(cs,0,len));
        }
        file.close();
        System.out.println(count);
    }*/

        FileReader file = new FileReader(new File("D:\\a.txt"));
        byte[] as = new byte[1024];
        while (true){
            int c = file.read();
        }
    }
}

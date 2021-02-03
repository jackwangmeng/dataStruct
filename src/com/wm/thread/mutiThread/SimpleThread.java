package com.wm.thread.mutiThread;

import java.sql.SQLOutput;

/**
 * @author wm
 * @Package com.wm.thread.mutiThread
 * @date 2021/2/3 12:00
 */
public class SimpleThread {

    private volatile static int count = 0;

    public static void main(String[] args) throws Exception {
        Runnable task = () -> {
            for (int i = 0; i < 1000000; ++i) {
                synchronized (SimpleThread.class) {
                    count = count + 1;
                }
            }
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);

        t1.start();
        t2.start();

        // 等待t1和t2执行完成
        t1.join();
        t2.join();

        System.out.println("count = " + count);
    }
}

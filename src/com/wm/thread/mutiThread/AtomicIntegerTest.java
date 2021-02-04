package com.wm.thread.mutiThread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author wm
 * @Package com.wm.thread.mutiThread
 * @date 2021/2/4 14:12
 */
public class AtomicIntegerTest {

    private static AtomicInteger count = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        Runnable task = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000000; i++) {
                    count.incrementAndGet();
                }
            }
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);

        t1.start();
        t2.start();

        t1.join();
        t2.join();
        System.out.println("count = " + count);
    }
}

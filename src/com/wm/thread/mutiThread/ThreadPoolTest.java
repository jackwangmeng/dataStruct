package com.wm.thread.mutiThread;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.logging.StreamHandler;

/**
 * @author wm
 * @Package com.wm.thread.mutiThread
 * @date 2021/2/3 12:00
 */
public class ThreadPoolTest {

    private volatile static int count = 0;

    public static void main(String[] args) throws Exception {
        Runnable task = () -> {
            for (int i = 0; i < 1000000; ++i) {
                synchronized (ThreadPoolTest.class) {
                    count = count + 1;
                }
            }
        };

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 0L,
                TimeUnit.MILLISECONDS, new LinkedBlockingDeque<>());
        threadPoolExecutor.execute(task);
        threadPoolExecutor.execute(task);

        threadPoolExecutor.shutdown();
        while(!threadPoolExecutor.awaitTermination(1L, TimeUnit.MILLISECONDS)) {
            System.out.println("not yet. Still waiting for termination");
        }
        System.out.println("count = " + count);
    }
}

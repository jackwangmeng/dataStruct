package com.wm.thread.mutiThread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author wm
 * @Package com.wm.thread.mutiThread
 * @date 2021/2/4 14:09
 */
public class ReenTrantLockTest {
    private volatile static int count = 0;

    public static void main(String[] args) throws Exception {
        final ReentrantLock locks = new ReentrantLock();
        Runnable task = () -> {
            for (int i = 0; i < 1000000; ++i) {
                locks.lock();
                try{
                    count += 1;
                } finally {
                    locks.unlock();
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

package com.wm.thread.twoRealizeOfThread;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

/**
 * @author wm
 * @Package com.wm.thread.twoRealizeOfThread
 * @date 2020/12/4 11:46
 */
public class ThreadTest {
    public static void main(String[] args) {
        Thread1 thread1 = new Thread1();
        Thread2 thread2 = new Thread2();

        thread1.start();
        thread2.start();
    }

}
class Thread1 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 1000; ++i) {
            System.out.println("Test1 " + i);
        }
    }
}

class Thread2 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 1000; ++i) {
            System.out.println("Test2 " + i);
        }
    }
}

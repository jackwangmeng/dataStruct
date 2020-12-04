package com.wm.thread.twoRealizeOfThread;

/**
 * @author wm
 * @Package com.wm.thread.twoRealizeOfThread
 * @date 2020/12/4 11:53
 */
public class ThreadRunnable {
    public static void main(String[] args) {
        Thread threadTest1 = new Thread((new ThreadTest1()));
        threadTest1.start();
        Thread threadTest2 = new Thread((new ThreadTest2()));
        threadTest2.start();
    }
}

class ThreadTest1 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 100; ++i) {
            System.out.println("Hello " + i);
        }
    }
}

class ThreadTest2 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 100; ++i) {
            System.out.println("Welcome: " + i);
        }
    }
}

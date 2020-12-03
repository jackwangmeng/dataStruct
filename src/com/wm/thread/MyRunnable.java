package com.wm.thread;

/**
 * @author wm
 * @Package com.wm.thread
 * @date 2020/12/3 11:18
 */
public class MyRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 99; i++) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        Runnable runnable = new MyRunnable();
        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        thread1.start();
        thread2.start();
    }
}

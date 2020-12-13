package com.wm.thread;

/**
 * @author wm
 * @Package com.wm.thread
 * @date 2020/12/3 11:14
 */
public class MyThread extends Thread {
    @Override
    public void run() {
        super.run();
        for (int i = 0; i < 99; i++) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        MyThread thread1 = new MyThread();
        MyThread thread2 = new MyThread();
        thread1.start();
        thread2.start();
    }
}

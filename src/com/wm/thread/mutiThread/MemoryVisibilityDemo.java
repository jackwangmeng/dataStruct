package com.wm.thread.mutiThread;

/**
 * @author wm
 * @Package com.wm.thread.mutiThread
 * @date 2021/2/4 14:38
 */
public class MemoryVisibilityDemo {

    private static volatile boolean flag;

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 100000; i++) {
            flag = false;

            final int no = i;

            Thread t1 = new Thread(new Runnable() {
                @Override
                public void run() {
                    flag = true;
                    System.out.println(String.format("No.%d loop, t1 is done.", no));
                }
            });

            Thread t2 = new Thread(new Runnable() {
                @Override
                public void run() {
                    while (!flag) ;
                    System.out.println(String.format("No.%d loop, t2 is done.", no));
                }
            });

            t1.start();
            t2.start();
            t1.join();
            t2.join();
        }
    }
}

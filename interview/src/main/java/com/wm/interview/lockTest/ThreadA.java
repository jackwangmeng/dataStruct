package com.wm.interview.lockTest;

/**
 * @author wm
 * @Package com.wm.interview.lockTest
 * @date 2021/2/25 11:15
 */
public class ThreadA extends Thread {

    private Service service;

    public ThreadA(Service service) {
        this.service = service;
    }

    @Override
    public void run() {
        service.seckill();
    }
}
 class Test{
     public static void main(String[] args) {
         Service service = new Service();
         for (int i = 0; i < 500; ++i) {
             ThreadA threadA = new ThreadA(service);
             threadA.start();
         }
     }
}

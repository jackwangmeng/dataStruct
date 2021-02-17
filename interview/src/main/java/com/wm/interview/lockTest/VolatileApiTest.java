package com.wm.interview.lockTest;

public class VolatileApiTest {
    public static void main(String[] args) {
        final VT vt = new VT();

        Thread thread1 = new Thread(vt);
        Thread thread2 = new Thread(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException ignore) {
            }
            vt.sign = true;
            System.out.println("vt.sign = true 通知 while (!sign) 结束!");
        });
        thread1.start();
        thread2.start();
    }
}

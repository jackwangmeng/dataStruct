package com.wm.interview.lockTest;

public class VT implements Runnable {

    public volatile boolean sign = false;

    @Override
    public void run() {
        while (!sign) {

        }
        System.out.println("you bad");
    }
}

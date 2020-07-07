package com.wm.thread;

import java.util.Timer;
import java.util.TimerTask;

public class TimerTastCus extends TimerTask {
    private static volatile int count = 0;
    @Override
    public void run() {
        count = (count + 1) % 2;
        System.out.println("Boob boom ");
        new Timer().schedule(new TimerTastCus(),2000 + count*2000);
    }
}



package com.wm.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @author wm
 * @Package com.wm.thread
 * @date 2020/12/3 11:20
 */
public class MyCall implements Callable<Integer> {

    public static void main(String[] args) {
        MyCall myCall = new MyCall();
        FutureTask<Integer> futureTask = new FutureTask<>(myCall);
        Thread thread = new Thread(futureTask);
        thread.start();
    }

    @Override
    public Integer call() throws Exception {
        for (int i = 0; i < 99; i++) {
            System.out.println(i);
        }
        return 0;
    }
}

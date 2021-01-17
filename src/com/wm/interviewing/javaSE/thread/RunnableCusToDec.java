package com.wm.interviewing.javaSE.thread;

public class RunnableCusToDec implements Runnable {

    private ShareData shareData;

    public RunnableCusToDec(ShareData shareData) {
        this.shareData = shareData;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            shareData.dec();
        }
    }

    public static void main(String[] args) {
        ShareData shareData = new ShareData();

        for (int i = 0; i < 4; i++) {
            if (i % 2 == 0) {
                new Thread(new RunnableCusToInc(shareData), "Thread " + i).start();

            } else {
                new Thread(new RunnableCusToDec(shareData), "Thread " + i).start();

            }
        }

        for (int i = 0; i < 6; i++) {
            if (i % 2 == 0) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        for (int i = 0; i < 5; i++) {
                            shareData.inc();
                        }
                    }
                }, "Thread " + i).start();
            }else {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        for (int i = 0; i < 5; i++) {
                            shareData.dec();
                        }
                    }
                }, "Thread" + i).start();
            }
        }
    }
}

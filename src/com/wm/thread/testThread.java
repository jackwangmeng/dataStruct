package com.wm.thread;

public class testThread {
    public static void main(String[] args) {
        /*new Thread(){
            @Override
            public void run() {
                while (true){
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();*/

        new Thread(){
            public void run(){
                try {
                    Thread.sleep(2000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName());
            }
        }.start();
    }
}

package com.wm.thread;

public class Bussiness {
    private boolean subFlag = true;
    public synchronized void mainMethod(){
        while (subFlag){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (int i = 0 ; i < 5 ; i++){
            System.out.println(Thread.currentThread().getName()
            + " : main thread running loop count -- " + i);
            try {
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        subFlag = true;
        notify();
    }

    public synchronized void subMethod(){
        while (!subFlag){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (int i = 0 ; i < 10 ; i++){
            System.out.println(Thread.currentThread().getName()
            + " sub thread running loop count -- " + i);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        subFlag = false;
        notify();
    }

}

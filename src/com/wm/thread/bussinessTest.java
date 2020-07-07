package com.wm.thread;
/*command ： 子线程运行执行10次，主线程再运行5次。这样一共交替3次*/
public class bussinessTest {
    public static void main(String[] args) {
        final Bussiness bussiness = new Bussiness();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0 ; i < 3; i++){
                    bussiness.subMethod();
                }
            }
        }).start();

        for (int i = 0 ; i < 3 ; i++){
            bussiness.mainMethod();
        }
    }
}

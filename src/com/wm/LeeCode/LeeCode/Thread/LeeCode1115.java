package com.wm.LeeCode.LeeCode.Thread;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author wm
 * @Package com.wm.LeeCode.LeeCode.Thread
 * @date 2020/12/17 10:33
 */
public class LeeCode1115 {
    /*class FooBar {
        private int n;
        private AtomicInteger jobDone = new AtomicInteger(0);


        public FooBar(int n) {
            this.n = n;
        }

        public void foo(Runnable printFoo) throws InterruptedException {

            for (int i = 0; i < n; i++) {
                while (jobDone.get() != 1) {

                }
                // printFoo.run() outputs "foo". Do not change or remove this line.
                printFoo.run();
                jobDone.incrementAndGet();
            }
        }

        public void bar(Runnable printBar) throws InterruptedException {

            for (int i = 0; i < n; i++) {
                while (jobDone.get() != 1) {

                }
                // printBar.run() outputs "bar". Do not change or remove this line.
                printBar.run();
                jobDone.incrementAndGet();
            }
        }
    }*/

    /*class FooBar {
        private int n;
        private Boolean finished;
        Object lock = new Object();

        public FooBar(int n) {
            this.n = n;
            finished = true;
        }

        public void foo(Runnable printFoo) throws InterruptedException {

            for (int i = 0; i < n; i++) {
                synchronized (lock) {
                    while (!finished) {
                        lock.wait();
                    }
                    printFoo.run();
                    finished = false;
                    lock.notifyAll();
                }
                // printFoo.run() outputs "foo". Do not change or remove this line.
            }
        }

        public void bar(Runnable printBar) throws InterruptedException {

            for (int i = 0; i < n; i++) {
                synchronized (lock) {
                    while (finished) {
                        lock.wait();
                    }
                    printBar.run();
                    finished = true;
                    lock.notifyAll();
                }
            }
        }
    }*/
    class FooBar {
        private int n;

        private Semaphore fooSemaphone = new Semaphore(1);
        private Semaphore barSemaphone = new Semaphore(0);

        public FooBar(int n) {
            this.n = n;
        }

        public void foo(Runnable printFoo) throws InterruptedException {

            for (int i = 0; i < n; i++) {
                fooSemaphone.acquire();
                printFoo.run();
                barSemaphone.release();
            }
        }

        public void bar(Runnable printBar) throws InterruptedException {

            for (int i = 0; i < n; i++) {
                barSemaphone.acquire();
                printBar.run();
                fooSemaphone.release();
            }
        }
    }
}

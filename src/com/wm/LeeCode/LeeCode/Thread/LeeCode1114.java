package com.wm.LeeCode.LeeCode.Thread;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author wm
 * @Package com.wm.LeeCode.LeeCode.Thread
 * @date 2020/12/16 17:18
 */
public class LeeCode1114 {
    /*//方案一
    class Foo {
        private AtomicInteger firstJobDone = new AtomicInteger(0);
        private AtomicInteger secondJobDone = new AtomicInteger(0);
        public Foo() {

        }

        public void first(Runnable printFirst) throws InterruptedException {

            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            firstJobDone.incrementAndGet();
        }

        public void second(Runnable printSecond) throws InterruptedException {
            while (firstJobDone.get() != 1) {

            }
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            secondJobDone.incrementAndGet();
        }

        public void third(Runnable printThird) throws InterruptedException {

            while (secondJobDone.get() != 1) {

            }
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
        }
    }*/
    //方案二
    /*class Foo {
        private Boolean firstFinished;
        private Boolean secondFinished;
        private Object lock = new Object();
        public Foo() {

        }

        public void first(Runnable printFirst) throws InterruptedException {

            // printFirst.run() outputs "first". Do not change or remove this line.
            synchronized (lock) {
                printFirst.run();
                firstFinished = true;
                lock.notifyAll();
            }
        }

        public void second(Runnable printSecond) throws InterruptedException {
            synchronized (lock) {
                while (!firstFinished) {
                    lock.wait();
                }
                printSecond.run();
                secondFinished = true;
                lock.notifyAll();
            }
            // printSecond.run() outputs "second". Do not change or remove this line.
        }

        public void third(Runnable printThird) throws InterruptedException {

            synchronized (lock) {
                while (!secondFinished) {
                    lock.wait();
                }
                printThird.run();
            }
            // printThird.run() outputs "third". Do not change or remove this line.
        }
    }*/
    /*class Foo {
        Semaphore semaphore12, semaphore23;
        public Foo() {
            semaphore12 = new Semaphore(0);
            semaphore23 = new Semaphore(0);
        }

        public void first(Runnable printFirst) throws InterruptedException {

            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            semaphore12.release();
        }

        public void second(Runnable printSecond) throws InterruptedException {
            semaphore12.acquire();
            printSecond.run();
            semaphore23.release();
            // printSecond.run() outputs "second". Do not change or remove this line.
        }

        public void third(Runnable printThird) throws InterruptedException {

            semaphore12.acquire();
            printThird.run();
            // printThird.run() outputs "third". Do not change or remove this line.
        }
    }*/
    class Foo {
        int num;
        Lock lock;
        Condition condition1, condition2, condition3;
        public Foo() {
            num = 1;
            lock = new ReentrantLock();
            condition1 = lock.newCondition();
            condition2 = lock.newCondition();
            condition3 = lock.newCondition();
        }

        public void first(Runnable printFirst) throws InterruptedException {
            lock.lock();
            try {
                while (num != 1) {
                    condition1.await();
                }
                printFirst.run();
                num = 2;
                condition2.signal();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public void second(Runnable printSecond) throws InterruptedException {
            lock.lock();
            try {
                while (num != 2) {
                    condition2.await();
                }
                printSecond.run();
                num = 3;
                condition3.signal();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public void third(Runnable printThird) throws InterruptedException {
            lock.lock();
            try {
                while (num != 3) {
                    condition3.await();
                }
                printThird.run();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

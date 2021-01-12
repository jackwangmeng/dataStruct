package com.wm.LeeCode.LeeCode.Thread;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntConsumer;

/**
 * @author wm
 * @Package com.wm.LeeCode.LeeCode.Thread
 * @date 2020/12/17 17:34
 */
public class LeeCode1116 {

    class ZeroEvenOdd {
        private int n;
        private AtomicInteger zeroJobDone = new AtomicInteger(0);
        private AtomicInteger evenJobDone = new AtomicInteger(0);
        private AtomicInteger oddJobDone = new AtomicInteger(0);

        public ZeroEvenOdd(int n) {
            this.n = n;
        }

        // printNumber.accept(x) outputs "x", where x is an integer.
        public void zero(IntConsumer printNumber) throws InterruptedException {

        }

        public void even(IntConsumer printNumber) throws InterruptedException {

        }

        public void odd(IntConsumer printNumber) throws InterruptedException {

        }
    }
}

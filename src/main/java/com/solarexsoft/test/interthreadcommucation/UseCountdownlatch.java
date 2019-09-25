package com.solarexsoft.test.interthreadcommucation;

import java.util.concurrent.CountDownLatch;

/**
 * Created by houruhou on 2019/3/15.
 * Desc:
 */
public class UseCountdownlatch {
    public static void main(String[] args) {
        int worker = 3;
        CountDownLatch countDownLatch = new CountDownLatch(worker);
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("D starts waiting for A,B,C to end");
                try {
                    countDownLatch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("All ends, D starts working");
            }
        }).start();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " starts working");
                UseJoin.printNumbers(Thread.currentThread().getName());
                countDownLatch.countDown();
            }
        };
        Thread A = new Thread(runnable, "A");
        Thread B = new Thread(runnable, "B");
        Thread C = new Thread(runnable, "C");
        A.start();
        B.start();
        C.start();
    }
}

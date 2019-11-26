package com.solarexsoft.test.interthreadcommucation;

/**
 * Created by houruhou on 2019/3/15.
 * Desc:
 */
public class UseJoinSeqence {
    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                UseJoin.printNumbers(Thread.currentThread().getName());
            }
        };
        Thread A = new Thread(runnable, "ThreadA");
        Thread B = new Thread(runnable, "ThreadB");
        Thread C = new Thread(runnable, "ThreadC");
        Thread D = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("D starts waiting for A,B,C ends");
                try {
                    A.join();
                    B.join();
                    C.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                UseJoin.printNumbers(Thread.currentThread().getName());
            }
        }, "ThreadD");
        A.start();
        B.start();
        C.start();
        D.start();
    }
}

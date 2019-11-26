package com.solarexsoft.test.interthreadcommucation;

/**
 * Created by houruhou on 2019/3/15.
 * Desc: https://www.tutorialdocs.com/article/java-inter-thread-communication.html
 */
public class UseJoin {
    public static void main(String[] args) {
        Thread A = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("A starts");
                printNumbers(Thread.currentThread().getName());
                System.out.println("A ends");
            }
        }, "ThreadA");
        Thread B = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("B starts waiting for A");
                try {
                    A.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                printNumbers(Thread.currentThread().getName());
            }
        }, "ThreadB");

        A.start();
        B.start();

    }
    public static void printNumbers(String threadname) {
        for (int i = 0; i < 3; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(threadname + ": " + i);
        }
    }
}

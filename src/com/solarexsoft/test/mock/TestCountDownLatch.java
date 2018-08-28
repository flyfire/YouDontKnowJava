package com.solarexsoft.test.mock;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

/**
 * Created by houruhou on 2018/8/25.
 */
public class TestCountDownLatch {
    public static long timeTasks(int num, final Runnable task) throws InterruptedException{
        final CountDownLatch startGate = new CountDownLatch(1);
        final CountDownLatch endGate = new CountDownLatch(num);

        for (int i = 0; i < num; i++) {
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        startGate.await();
                        try {
                            task.run();
                        } finally {
                            endGate.countDown();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            t.start();
        }
        long start = System.nanoTime();
        startGate.countDown();
        endGate.await();
        long end = System.nanoTime();
        return end - start;
    }

    public static void main(String[] args) throws InterruptedException{
        long duration = timeTasks(1000, new Runnable() {
            @Override
            public void run() {
                long sum = 0;
                Random random = new Random(System.nanoTime());
                for (int i = 0; i < 10000; i++) {
                    sum += random.nextInt();
                }
                System.out.println(Thread.currentThread().getId() + " --> " + sum);
            }
        });
        System.out.println("duration = " + duration);
    }
}

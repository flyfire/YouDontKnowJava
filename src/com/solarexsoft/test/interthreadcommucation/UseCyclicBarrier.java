package com.solarexsoft.test.interthreadcommucation;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by houruhou on 2019/3/15.
 * Desc:
 */
public class UseCyclicBarrier {
    public static void main(String[] args) {
        int runner = 3;
        CyclicBarrier cyclicBarrier = new CyclicBarrier(runner);
        Random random = new Random();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                long prepareTime = random.nextInt(10000) + 100;
                String name = Thread.currentThread().getName();
                System.out.println(name + " is preparing for time: " + prepareTime);
                try {
                    Thread.sleep(prepareTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(name + " is prepared, waiting for others");
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
                System.out.println(name + " starts running");
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

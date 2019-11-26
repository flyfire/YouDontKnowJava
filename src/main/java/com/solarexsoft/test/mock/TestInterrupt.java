package com.solarexsoft.test.mock;

/**
 * Created by houruhou on 2018/8/25.
 */
public class TestInterrupt {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("aaaa");
                try {
                    throw new InterruptedException("solarex interrupt");
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                System.out.println("bbb");
            }
        }).start();
        System.out.println("000");
    }
}

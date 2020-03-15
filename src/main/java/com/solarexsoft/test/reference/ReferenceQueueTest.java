package com.solarexsoft.test.reference;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/**
 * Created by houruhou on 2020/1/14.
 * Desc:
 */
public class ReferenceQueueTest {
    public static void main(String[] args) {
        ReferenceQueue<String> queue = new ReferenceQueue<>();
        TestThread t = new TestThread(queue);
        t.start();
        String str = new String("abc");
        WeakReference<String> weakReference = new WeakReference<>(str, queue);
        System.out.println("gc前: " + weakReference.get());
        str = null;
        System.gc();
        System.out.println("gc后：" + weakReference.get());
        System.out.println(t.isAlive());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
//        t.setShutdown(true);
        t.interrupt();
        System.out.println("sleep 后: " + t.isAlive());
        System.out.println("main");
    }

    static class TestThread extends Thread {
        volatile boolean isShutdown = false;
        ReferenceQueue<String> queue;
        int count = 0;
        TestThread(ReferenceQueue<String> queue) {
            this.queue = queue;
        }
        @Override
        public void run() {
            while (!isShutdown) {
                System.out.println(++count);
                try {
                    Reference<? extends String> remove = queue.remove(500);
                    if (remove != null) {
                        System.out.println("被回收了： " + remove.get());
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    break;
                }
                System.out.println(++count);
            }
        }

        public void setShutdown(boolean shutdown) {
            isShutdown = shutdown;
        }
    }
}

/*
gc前: abc
1
gc后：null
true
被回收了： null
2
3
4
5
sleep 后: true
main
6
 */

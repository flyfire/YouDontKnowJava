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
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    System.out.println(1);
                    try {
                        Reference<? extends String> remove = queue.remove();
                        System.out.println("被回收了： " + remove.get());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(2);
                }
            }
        });
        t.start();
        String str = new String("abc");
        WeakReference<String> weakReference = new WeakReference<>(str, queue);
        System.out.println("gc前: " + weakReference.get());
        str = null;
        System.gc();
        System.out.println("gc后：" + weakReference.get());
        System.out.println(t.isAlive());
    }

}

/*
1
gc前: abc
gc后：null
true
被回收了： null
2
1
 */

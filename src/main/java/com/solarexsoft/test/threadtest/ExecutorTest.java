package com.solarexsoft.test.threadtest;

import org.jetbrains.annotations.NotNull;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by houruhou on 2020/3/30.
 * Desc:
 */
public class ExecutorTest {
    public static class InnerRunnable implements Runnable {
        final int i;

        public InnerRunnable(int i) {
            this.i = i;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(Long.MAX_VALUE);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        @Override
        public String toString() {
            return String.valueOf(i);
        }
    }

    public static void main(String[] args) {
        LinkedBlockingQueue<Runnable> queue = new LinkedBlockingQueue<>(5);
        ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 5, 60, TimeUnit.SECONDS, queue, new ThreadFactory() {
            @Override
            public Thread newThread(@NotNull Runnable r) {
                return new Thread(r, r.toString());
            }
        });
        for (int i = 0; i < 10; i++) {
            executor.execute(new InnerRunnable(i));
        }
        System.out.println(queue);
        ThreadMXBean bean = ManagementFactory.getThreadMXBean();
        long[] allThreadIds = bean.getAllThreadIds();
        for (int i = 0; i < allThreadIds.length; i++) {
            System.out.println(bean.getThreadInfo(allThreadIds[i]));
        }
    }
}

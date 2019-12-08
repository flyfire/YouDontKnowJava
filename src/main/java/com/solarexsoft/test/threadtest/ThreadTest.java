package com.solarexsoft.test.threadtest;

import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * Created by houruhou on 2019/12/8.
 * Desc:
 */
public class ThreadTest {
    public static void main(String[] args) {
        OperatingSystemMXBean os = ManagementFactory.getOperatingSystemMXBean();
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        int threadCount = threadMXBean.getThreadCount();
        long[] allThreadIds = threadMXBean.getAllThreadIds();
        for (long allThreadId : allThreadIds) {
            ThreadInfo threadInfo = threadMXBean.getThreadInfo(allThreadId);
            System.out.println("thread name = " + threadInfo.getThreadName());
        }
    }
}

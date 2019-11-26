package com.solarexsoft.test.monitorlock;

/**
 * Created by houruhou on 2018/7/16.
 */
public class Father {
    public synchronized void doSomething() {
        System.out.println("Father doSomething");
    }
}

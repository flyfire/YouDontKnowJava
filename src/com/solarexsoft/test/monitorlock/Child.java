package com.solarexsoft.test.monitorlock;

/**
 * Created by houruhou on 2018/7/16.
 */
public class Child extends Father {
    @Override
    public synchronized void doSomething() {
        System.out.println("child doSomething");
        super.doSomething();
    }
}

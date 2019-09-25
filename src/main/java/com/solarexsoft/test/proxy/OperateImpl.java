package com.solarexsoft.test.proxy;

/**
 * Created by houruhou on 18/06/2017.
 */
public class OperateImpl implements Operate {
    @Override
    public void operateMethod1() {
        System.out.println("method1");
        sleep(1000);
    }

    @Override
    public void operateMethod2() {
        System.out.println("method2");
        sleep(500);
    }

    @Override
    public void operateMethod3() {
        System.out.println("method3");
        sleep(400);
    }

    public void sleep(int ms){
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

package com.solarexsoft.test.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by houruhou on 18/06/2017.
 */
public class SolarexInvocationHandler implements InvocationHandler {
    private Object target;
    int i = 0;
    public SolarexInvocationHandler(Object o) {
        this.target = o;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(System.currentTimeMillis());
        System.out.println(i++);
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Object o = method.invoke(proxy, args);
        System.out.println(System.currentTimeMillis());
        System.out.println("-----------------");
        return o;
    }
}

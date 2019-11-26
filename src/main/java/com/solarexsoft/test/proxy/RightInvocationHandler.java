package com.solarexsoft.test.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by houruhou on 18/06/2017.
 */
public class RightInvocationHandler implements InvocationHandler {
    private Object target;
    public RightInvocationHandler(Object o){
        this.target = o;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(System.currentTimeMillis());
        Object o = method.invoke(target, args);
        System.out.println(System.currentTimeMillis());
        return o;
    }
}

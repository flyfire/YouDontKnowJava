package com.solarexsoft.test.proxy;

import java.lang.reflect.Proxy;

/**
 * Created by houruhou on 18/06/2017.
 */
public class Test {

    public static void main(String[] args) {
        //SolarexInvocationHandler invocationHandler = new SolarexInvocationHandler(new OperateImpl());
        RightInvocationHandler invocationHandler = new RightInvocationHandler(new OperateImpl());
        Operate operate = (Operate) Proxy.newProxyInstance(Operate.class.getClassLoader(), OperateImpl.class.getInterfaces(), invocationHandler);
        operate.operateMethod1();
        operate.operateMethod2();
        operate.operateMethod3();
    }
}

//com.sun.proxy.$Proxy0 extends Proxy implement Operate{
//  InvocationHandler invocationHandler;
//  $Proxy0(InvocationHandler h){
//      invocationHandler = h;//super(h)
//  }
//  void operateMethod1(){
//      invocationHandler.invoke(this, method1, args);
//  }
//}
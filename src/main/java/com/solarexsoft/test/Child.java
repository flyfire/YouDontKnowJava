package com.solarexsoft.test;

/**
 * Created by houruhou on 01/06/2017.
 */
public class Child extends Parent {
    public static String staticField = "子类静态变量";
    public String field = "子类变量";

    static {
        System.out.println("staticField = " + staticField);
        System.out.println("子类静态初始化区");
    }

    {
        System.out.println("field = " + field);
        System.out.println("子类初始化区");
    }

    public Child() {
        System.out.println("子类构造函数");
    }
}

package com.solarexsoft.test;

/**
 * Created by houruhou on 01/06/2017.
 */
public class Parent {
    public static String pStaticField = "父类静态变量";
    public String pField = "父类变量";

    static {
        System.out.println("pStaticField = " + pStaticField);
        System.out.println("父类静态初始化块区");
    }

    {
        System.out.println("pField = " + pField);
        System.out.println("父类初始化块区");
    }

    public Parent() {
        System.out.println("父类构造器");
    }

}

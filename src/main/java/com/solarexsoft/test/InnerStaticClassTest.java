package com.solarexsoft.test;

/**
 * Created by houruhou on 01/06/2017.
 */
public class InnerStaticClassTest {
    public static String staticField = "类静态变量";
    public String field = "类变量";

    static {
        System.out.println("staticField = " + staticField);
        System.out.println("类静态初始化区");
    }

    {
        System.out.println("field = " + field);
        System.out.println("类初始化区");
    }

    public InnerStaticClassTest() {
        System.out.println("类构造函数");
    }

    public void testStatic() {
        String tmp = Holder.staticField;
    }

    public void testNonStatic() {
        new Holder();
    }

    public static class Holder {
        public static String staticField = "内部类静态变量";
        public String field = "内部类变量";

        static {
            System.out.println("staticField = " + staticField);
            System.out.println("内部类静态初始化区");
        }

        {
            System.out.println("field = " + field);
            System.out.println("内部类初始化区");
        }

        public Holder() {
            System.out.println("内部类构造函数");
        }
    }
}

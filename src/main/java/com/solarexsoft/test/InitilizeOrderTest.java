package com.solarexsoft.test;

/**
 * Created by houruhou on 01/06/2017.
 */
public class InitilizeOrderTest {
    public static void main(String args[]) {
        //new Child();
        //new InnerStaticClassTest();
        //new InnerStaticClassTest().testStatic();
        new InnerStaticClassTest().testNonStatic();
    }
}

/*
pStaticField = 父类静态变量
父类静态初始化块区
staticField = 子类静态变量
子类静态初始化区
pField = 父类变量
父类初始化块区
父类构造器
field = 子类变量
子类初始化区
子类构造函数
 */
/*
staticField = 类静态变量
类静态初始化区
field = 类变量
类初始化区
类构造函数
 */
/*
staticField = 类静态变量
类静态初始化区
field = 类变量
类初始化区
类构造函数
staticField = 内部类静态变量
内部类静态初始化区
 */
/*
staticField = 类静态变量
类静态初始化区
field = 类变量
类初始化区
类构造函数
staticField = 内部类静态变量
内部类静态初始化区
field = 内部类变量
内部类初始化区
内部类构造函数
 */
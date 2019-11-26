package com.solarexsoft.test.loader;

/**
 * Created by houruhou on 17/09/2017.
 */
class C{
    static {
        System.out.println("C static block");
    }
}
public class TestInit2 {
    public static void main(String[] args) throws Exception{
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        classLoader.loadClass("com.solarexsoft.test.loader.C");
        System.out.println("--------------------");
//        classLoader.loadClass("com.solarexsoft.test.loader.C").newInstance();
        Class.forName("com.solarexsoft.test.loader.C");
    }
}

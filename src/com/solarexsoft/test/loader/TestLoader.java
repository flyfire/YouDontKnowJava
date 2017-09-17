package com.solarexsoft.test.loader;

/**
 * Created by houruhou on 17/09/2017.
 */
class Singleton {
    private static Singleton sInstance = new Singleton();
    public static int counter1;
    public static int counter2 = 0;

//    private static Singleton sInstance = new Singleton();
    private Singleton() {
        counter1++;
        counter2++;
    }

    public static Singleton getInstance() {
        return sInstance;
    }
}

public class TestLoader {
    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
        System.out.println(singleton.counter1);
        System.out.println(singleton.counter2);
    }
}

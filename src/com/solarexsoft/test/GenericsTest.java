package com.solarexsoft.test;

/**
 * Created by houruhou on 21/05/2017.
 */
public class GenericsTest<K, V> {
    public <K, V> K test(K k) {
        System.out.println("test");
        //testk(k);
        System.out.println(k.getClass());
        System.out.println("--------");
        return k;
    }

    public K testk(K k) {
        System.out.println("testk");
//        Integer v = new Integer(1);
//        this.test(k);
//        this.<K,V>test(k);
        System.out.println(k.getClass());
        return k;
    }

    public static class A {
    }

    public static class B {
    }

    public K test1(K k) {
        A a = new A();
        this.<A,B>test(a);
        return null;
    }
}

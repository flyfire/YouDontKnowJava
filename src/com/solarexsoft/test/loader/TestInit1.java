package com.solarexsoft.test.loader;

/**
 * Created by houruhou on 17/09/2017.
 */
class Parent {
    public static int a = 3;

    static {
        System.out.println("Parent static block");
    }

    public static void doSth() {
        System.out.println("Parent doSth");
    }
}

class Child extends Parent {
    static {
        System.out.println("Child static block");
    }
}

public class TestInit1 {
    public static void main(String[] args) {
        System.out.println(Child.a);
        Child.doSth();
    }
}

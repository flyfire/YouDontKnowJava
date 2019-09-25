package com.solarexsoft.test.enumtest.enuminterface;

/**
 * Created by houruhou on 2019/6/3.
 * Desc:
 */
public class Test {
    private static <T extends Enum<T> & Operation> void test(Class<T> opSet, double x, double y) {
        for (Operation op : opSet.getEnumConstants()) {
            System.out.printf("%f %s %f = %f%n", x, op, y, op.apply(x, y));
        }
    }

    public static void main(String[] args) {
        double a = 10.0;
        double b = 5.0;
        test(BasicOperation.class, a, b);
    }
}

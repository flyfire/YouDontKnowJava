package com.solarexsoft.test.exceptiontable;

/**
 * Created by houruhou on 2020/3/15.
 * Desc:
 */
public class ExceptionTest {
    public static void main(String[] args) {
//        test1();
        test2();
    }

    private static void test2() {
        try {
            int i = 1/0;
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    private static void test1() {
        try {
            int i = 1 / 0;
        }catch (IllegalArgumentException e) {
            e.printStackTrace();
        } finally {
            System.out.println("solarex hahaha");
        }
        /*
        Exception table:
       from    to  target type
           0     4    15   Class java/lang/IllegalArgumentException
           0     4    31   any
          15    20    31   any
         */
    }
}

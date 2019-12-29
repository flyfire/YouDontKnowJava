package com.solarexsoft.test.exceptiontable;

/**
 * Created by houruhou on 2019/12/29.
 * Desc:
 */
public class ExceptionTable {
    private static int inc1() {
        int x;
        try {
            x = 1;
            return x;
        } catch (Exception e) {
            x = 2;
            return x;
        } finally {
            x = 3;
        }
    }

    private static int inc2() {
        int x;
        try {
            x = 1;
            return x;
        } catch (Exception e) {
            x = 2;
            return x;
        } finally {
            x = 3;
            return x;
        }
    }

    private static int inc3() {
        int x;
        Integer a = null;
        try {
            x = 1;
            a.byteValue();
            return x;
        } catch (Exception e) {
            x = 2;
            return x;
        } finally {
            x = 3;
        }
    }

    private static int inc4() {
        int x;
        Integer a = null;
        try {
            x = 1;
            a.byteValue();
            return x;
        } catch (Exception e) {
            x = 2;
            return x;
        } finally {
            x = 3;
            return x;
        }
    }

    private static int inc5() {
        int x;
        Integer a = null;
        try {
            x = 1;
            a.byteValue();
            return x;
        } catch (Exception e) {
            x = 2;
//            a.byteValue();
            return x;
        } finally {
            x = 3;
        }
    }

    private static int inc6() {
        int x;
        Integer a = null;
        try {
            x = 1;
            a.byteValue();
            return x;
        } catch (Exception e) {
            x = 2;
            a.byteValue();
            return x;
        } finally {
            x = 3;
            return x;
        }
    }

    public static void main(String[] args) {
        System.out.printf("inc1 = " + inc1() + "\ninc2 = " + inc2() + "\ninc3 = " + inc3() + "\ninc4 = " + inc4() + "\ninc5 = " + inc5() + "\ninc6 = " + inc6());
    }
}

/*
inc1 = 1
inc2 = 3
inc3 = 2
inc4 = 3
inc5 = 2
inc6 = 3

javap -p -c ExceptionTable
 */

package com.solarexsoft.test.bittest;

/**
 * Created by houruhou on 2020/3/17.
 * Desc:
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.toBinaryString(Integer.MAX_VALUE));
        int tmp = Integer.MAX_VALUE + 1;
        System.out.println(tmp);
        System.out.println(Integer.toBinaryString(tmp));
        System.out.println(tmp >> 1);
        System.out.println(Integer.toBinaryString(tmp >> 1));
        System.out.println(tmp >>> 1);
        System.out.println(Integer.toBinaryString(tmp >>> 1));
    }
}

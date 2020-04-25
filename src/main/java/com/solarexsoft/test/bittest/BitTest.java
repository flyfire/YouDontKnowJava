package com.solarexsoft.test.bittest;

public class BitTest {
    public static void main(String[] args) {
        System.out.println(8>>1);
        System.out.println(8>>>1);
        System.out.println(Integer.toBinaryString(8));
        System.out.println(Integer.toBinaryString(8>>1));
        System.out.println(Integer.toBinaryString(8>>>1));
        System.out.println(-8>>1);
        System.out.println(-8>>>1);
        System.out.println(Integer.toBinaryString(-8));
        System.out.println(Integer.toBinaryString(-8>>1));
        System.out.println(Integer.toBinaryString(-8>>>1));
        System.out.println(Integer.toBinaryString(~1));
    }
}

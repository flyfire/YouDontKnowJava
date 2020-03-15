package com.solarexsoft.test.stringtest;

import java.lang.reflect.Array;
import java.lang.reflect.Field;

public class Main {
    public static void main(String[] args) {
        try {
            String s = "solarex";
            System.out.println(s + " ---- " + System.identityHashCode(s));
            Field value = String.class.getDeclaredField("value");
            value.setAccessible(true);
            char[] sValue = (char[]) value.get(s);
            Array.setChar(sValue, 0, 'S');
            System.out.println(s + " ---- " + System.identityHashCode(s));
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
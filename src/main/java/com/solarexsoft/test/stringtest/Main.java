package com.solarexsoft.test.stringtest;

import java.lang.reflect.Array;
import java.lang.reflect.Field;

public class Main {
    public static void main(String[] args) {
        try {
            String s = "solarex";
            Field value = String.class.getDeclaredField("value");
            value.setAccessible(true);
            char[] sValue = (char[]) value.get(s);
            Array.setChar(sValue, 0, 'S');
            System.out.println(s);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
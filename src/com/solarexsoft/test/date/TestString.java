package com.solarexsoft.test.date;

/**
 * Created by houruhou on 2018/9/11.
 */
public class TestString {
    public static void main(String[] args) {
        String str = "08:00";
        String[] split = str.split(":");
        for (int i = 0; i < split.length; i++) {
            System.out.println(split[i]);
        }
    }
}

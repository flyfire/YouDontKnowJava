package com.solarexsoft.test.reflection;

import java.lang.reflect.Field;

/**
 * Created by houruhou on 18/06/2017.
 */
public class Test {
    public static void main(String[] args) {
        Class clazz = User.class;
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            Class<?> clz = field.getType();
            System.out.println(field.getName() + " --> " + clz);
        }
    }
}

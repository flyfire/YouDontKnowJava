package com.solarexsoft.test.generics;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Created by houruhou on 2020/4/25.
 * Desc:
 */
public class PeiQi extends Pig<Integer, Boolean> {
    public static void main(String[] args) {
        PeiQi peiQi = new PeiQi();
        Class clz = peiQi.getClass();
        System.out.println(clz.getSuperclass());
        // getGenericSuperclass()获得带有泛型的父类
        // Type是 Java 编程语言中所有类型的公共高级接口。它们包括原始类型、参数化类型、数组类型、类型变量和基本类型。
        Type type = clz.getGenericSuperclass();
        System.out.println(type);
        ParameterizedType parameterizedType = (ParameterizedType) type;
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        for (int i = 0; i < actualTypeArguments.length; i++) {
            System.out.println(actualTypeArguments[i]);
        }
    }
}

package com.solarexsoft.test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {
        getParamizedReturnType();
        getParamizedParameterType();
        getParamizedFieldType();
        testGenerics();
        testIncrement();
        testSimpleFormat();
    }

    private static void testSimpleFormat() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        String date = formatter.format(new Date(1506566460000l));
        System.out.println(date);
        String[] dates = date.split(" ");
        System.out.println(dates[0]);
        System.out.println(dates[1]);
        System.out.println(Long.MAX_VALUE);
        System.out.println(Integer.MAX_VALUE);
    }

    private static void testIncrement() {
        int count = 0;
        for (int i = 0; i < 100; i++) {
            count = count++;
            System.out.println("i = " + i + ",count = " + count);
        }
        System.out.println(count);//0
    }

    private static void testGenerics() {
        GenericsTest<Integer, String> test = new GenericsTest<>();
        test.<Boolean, Double>test(false);
        test.testk(1);
        test.test1(1);
    }

    private static void getParamizedFieldType() throws NoSuchFieldException {
        //Field field = A.class.getField("b");
        //Field[] fields = A.class.getFields();
        Field[] fields = A.class.getDeclaredFields();
        System.out.println(fields.length);
        for (Field field : fields) {
            System.out.println(field);
            System.out.println(field.getType());
            Type tmp = field.getGenericType();
            if (tmp instanceof ParameterizedType){
                ParameterizedType tmptmp = (ParameterizedType) tmp;
                Type[] types = tmptmp.getActualTypeArguments();
                for (Type type: types){
                    System.out.println(type);
                }
            }
            System.out.println("-------------------");
        }
    }

    private static void getParamizedParameterType() throws NoSuchMethodException {
        //Method method = A.class.getMethod("setStrList", List.class);
        Method method = A.class.getMethod("setHashMap", HashMap.class);
        Type[] types = method.getGenericParameterTypes();
        for (Type type : types) {
            if (type instanceof ParameterizedType) {
                ParameterizedType pType = (ParameterizedType) type;
                Type[] paraTypes = pType.getActualTypeArguments();
                for (Type type1 : paraTypes) {
                    System.out.println(type1);
                }
            }
        }
    }

    private static void getParamizedReturnType() throws NoSuchMethodException {
        Method method = A.class.getMethod("getStrList", null);
        Type type = method.getGenericReturnType();
        if (type instanceof ParameterizedType) {
            ParameterizedType tmpType = (ParameterizedType) type;
            Type[] actualTypes = tmpType.getActualTypeArguments();
            for (Type actualType : actualTypes) {
                //System.out.println(actualType);
                Class clz = (Class) actualType;
                System.out.println(clz);
            }
        }
    }
}

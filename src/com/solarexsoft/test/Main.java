package com.solarexsoft.test;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws Exception {
        getParamizedReturnType();
        getParamizedParameterType();
        getParamizedFieldType();
        testGenerics();
        testIncrement();
        testSimpleFormat();
        testTreeSet();
        testEpoch();
        testBigDecimal();
        testTime();
        testSplit();
        testChar();
    }

    private static void testChar() {
        ArrayList<String> test = new ArrayList<>();
        for (char i = 'A'; i <= 'Z'; i++) {
            test.add(String.valueOf(i));
        }
        System.out.println(test);
    }

    private static void testSplit() {
        String str = "剩余1天";
        String[] split = str.split("\\D+");
        for (String s : split) {
            System.out.println(s);
        }
        System.out.println(split[1]);
    }

    private static void testTime() {
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        System.out.println("----------------------");
        System.out.println(calendar.getTimeInMillis());
        calendar.add(Calendar.HOUR, -1);
        System.out.println(calendar.getTimeInMillis());
        calendar.add(Calendar.HOUR, -1);
        System.out.println(calendar.getTimeInMillis());
        calendar.add(Calendar.DATE, -1);
        System.out.println("------------------");
        System.out.println(calendar.getTimeInMillis());
        calendar.add(Calendar.DATE, -1);
        System.out.println(calendar.getTimeInMillis());
    }

    private static void testBigDecimal() {
        BigDecimal decimal = new BigDecimal(7.88888889f);
        System.out.println(decimal.setScale(3, 4).doubleValue());
        String[] weekday = {"sun", "mon", "tue", "wed", "thr", "fri", "sat"};
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int index = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        System.out.println(weekday[index]);
        System.out.println(calendar.get(Calendar.MONTH));
    }

    private static void testEpoch() {
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        //   calendar.add(Calendar.DATE, -7);
        calendar.set(Calendar.HOUR, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        System.out.println(calendar.getTimeInMillis());
        calendar.add(Calendar.DATE, -1);
        System.out.println(calendar.getTimeInMillis());
        calendar.add(Calendar.DATE, -1);
        System.out.println(calendar.getTimeInMillis());
        calendar.add(Calendar.DATE, -1);
        System.out.println(calendar.getTimeInMillis());
        calendar.add(Calendar.DATE, -1);
        System.out.println(calendar.getTimeInMillis());
        calendar.add(Calendar.DATE, -1);
        System.out.println(calendar.getTimeInMillis());
        calendar.add(Calendar.DATE, -1);
        System.out.println(calendar.getTimeInMillis());
        System.out.println(TimeUnit.DAYS.toMillis(1));
        float scale = 34.123456f;
        float result = (float) (Math.round(scale * 100)) / 100;
        System.out.println(result);
        DecimalFormat format = new DecimalFormat("##0.00");
        System.out.println(format.format(scale));
        System.out.println(TimeUnit.HOURS.toMillis(1));
        System.out.println(60 * 60 * 1000);
        System.out.println(TimeUnit.MINUTES.toMillis(1));
        System.out.println(60 * 1000);
    }

    private static void testTreeSet() {
        TreeSet<File> sets = new TreeSet<>(new Comparator<File>() {
            @Override
            public int compare(File o1, File o2) {
                long o1last = o1.lastModified();
                long o2last = o2.lastModified();
                long diff = o1last - o2last;
                System.out.println("o1last = " + o1last + ",o2last = " + o2last + ",diff = " + diff);
                int ret = (diff == 0) ? 0 : ((diff > 0) ? 1 : -1);
                return ret;
            }
        });
        File file1 = new File("/Users/houruhou/main.py");
        file1.setLastModified(System.currentTimeMillis());
        File file2 = new File("/Users/houruhou/settings.jar");
        file2.setLastModified(System.currentTimeMillis() - 1000);
        sets.add(file1);
        sets.add(file2);
        Iterator<File> iterator = sets.iterator();
        System.out.println(sets);
        System.out.println(sets.descendingSet());
        while (iterator.hasNext()) {
            File file = iterator.next();
            iterator.remove();
        }
        System.out.println(sets);
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
            if (tmp instanceof ParameterizedType) {
                ParameterizedType tmptmp = (ParameterizedType) tmp;
                Type[] types = tmptmp.getActualTypeArguments();
                for (Type type : types) {
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

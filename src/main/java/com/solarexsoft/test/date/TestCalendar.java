package com.solarexsoft.test.date;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by houruhou on 2018/11/19.
 * Desc:
 */
public class TestCalendar {
    public static void main(String[] args) {
//        c1();
        c2();
    }

    private static void c2() {
        Calendar qiantianCal = Calendar.getInstance();
        Calendar zuotianCal = Calendar.getInstance();
        Calendar jintianCal = Calendar.getInstance();
        Date now = new Date();
        qiantianCal.setTime(now);
        qiantianCal.add(Calendar.DATE, -2);
        qiantianCal.set(Calendar.HOUR_OF_DAY, 0);
        qiantianCal.set(Calendar.MINUTE, 0);
        qiantianCal.set(Calendar.SECOND, 0);
        qiantianCal.set(Calendar.MILLISECOND, 0);
        long qiantian = qiantianCal.getTimeInMillis();
        zuotianCal.setTime(now);
        zuotianCal.add(Calendar.DATE, -1);
        zuotianCal.set(Calendar.HOUR_OF_DAY, 0);
        zuotianCal.set(Calendar.MINUTE, 0);
        zuotianCal.set(Calendar.SECOND, 0);
        zuotianCal.set(Calendar.MILLISECOND, 0);
        long zuotian = zuotianCal.getTimeInMillis();
        jintianCal.setTime(now);
        jintianCal.set(Calendar.HOUR_OF_DAY, 0);
        jintianCal.set(Calendar.MINUTE, 0);
        jintianCal.set(Calendar.SECOND, 0);
        jintianCal.set(Calendar.MILLISECOND, 0);
        long jintian = jintianCal.getTimeInMillis();
        Date bindTimeDate = new Date(jintian);
        int hours = bindTimeDate.getHours();
        System.out.println(qiantian);
        System.out.println(zuotian);
        System.out.println(jintian);
        System.out.println(hours);
    }
    private static void c1() {
        Date now = new Date();
        Calendar qiantianCal = Calendar.getInstance();
        qiantianCal.setTime(now);
        qiantianCal.add(Calendar.DATE, -2);
        qiantianCal.set(Calendar.HOUR, 0);
        qiantianCal.set(Calendar.MINUTE, 0);
        qiantianCal.set(Calendar.SECOND, 0);
        qiantianCal.set(Calendar.MILLISECOND, 0);
        long qiantian = qiantianCal.getTimeInMillis();
        System.out.println(qiantian);
        System.out.println(now.getTime());
        System.out.println(now.getHours());
    }
}

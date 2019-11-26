package com.solarexsoft.test.date;

import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by houruhou on 2019/9/25.
 * Desc:
 */
public class CalendarCalUtilsTest {
    @Test
    public void getWeekStartEndTest() {
        System.out.println(CalendarCalUtils.getWeekStartEnd(new Date()));

        CalendarCalUtils.SelectDays<Date> selectDays = CalendarCalUtils.getWeekStartEnd(new Date());
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(selectDays.getStart());
        calendar.add(Calendar.DATE, -7);
        System.out.println(calendar.getTime());
    }

    @Test
    public void getMonthStartEndTest() {
        System.out.println(CalendarCalUtils.getMonthStartEnd(new Date()));
    }

    @Test
    public void getDaysForMonthTest() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);

        int days = CalendarCalUtils.getDaysForMonth(month, year);
        System.out.println(days);
    }

    @Test
    public void testInteger(){
        System.out.println(Character.digit('b', 15));
        System.out.println(Integer.parseInt("abc1", 15));
    }
    @Test
    public void testHourMinute() {
        CalendarCalUtils.calHourMinute(32700);
    }
}
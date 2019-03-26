package com.solarexsoft.test.date;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by houruhou on 2019/3/18.
 * Desc:
 */
class CalendarCalUtilsTest {

    @org.junit.jupiter.api.Test
    void getWeekStartEndTest() {
        System.out.println(CalendarCalUtils.getWeekStartEnd(new Date()));

        CalendarCalUtils.SelectDays<Date> selectDays = CalendarCalUtils.getWeekStartEnd(new Date());
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(selectDays.getStart());
        calendar.add(Calendar.DATE, -7);
        System.out.println(calendar.getTime());
    }

    @org.junit.jupiter.api.Test
    void getMonthStartEndTest() {
        System.out.println(CalendarCalUtils.getMonthStartEnd(new Date()));
    }

    @org.junit.jupiter.api.Test
    void getDaysForMonthTest() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);

        int days = CalendarCalUtils.getDaysForMonth(month, year);
        System.out.println(days);
    }
}
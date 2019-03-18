package com.solarexsoft.test.date;

import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by houruhou on 2019/3/18.
 * Desc:
 */
class CalendarCalUtilsTest {

    @org.junit.jupiter.api.Test
    void getWeekStartEndTest() {
        System.out.println(CalendarCalUtils.getWeekStartEnd(new Date()));
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
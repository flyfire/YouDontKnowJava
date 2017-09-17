package com.solarexsoft.test.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * Created by houruhou on 14/09/2017.
 */
public class TestDate {
    public static void main(String args[]) {
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd HH:mm:ss", Locale.CHINA);
        try {
            Date date = format.parse("20170901 04:00:00");
            System.out.println(date.getTime());
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.set(Calendar.HOUR_OF_DAY, 0);
            calendar.set(Calendar.MINUTE, 0);
            calendar.set(Calendar.SECOND, 0);
            calendar.set(Calendar.MILLISECOND, 0);
            long time = calendar.getTime().getTime();
            System.out.println(time);
            format = new SimpleDateFormat("yyyy.MM.dd");
            String formated = format.format(date);
            System.out.println(formated);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}

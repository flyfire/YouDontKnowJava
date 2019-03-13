package com.solarexsoft.test.date;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by houruhou on 2019/2/22.
 * Desc:
 */
public class TestDateEquals {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        Date date1 = calendar.getTime();
        Date date2 = calendar.getTime();
        Date date3 = calendar.getTime();
        Date date4 = calendar.getTime();

        if (date1.getTime() == date2.getTime() || date3.getTime() == date4.getTime()) {
            System.out.println("true");
        }
        if (date1 == date2) {
            System.out.println("1");
        }
        if (date3 == date4) {
            System.out.println("2");
        }
        if ((date1 == date2) || (date3 == date4)) {
            System.out.println("3");
        }
    }
}

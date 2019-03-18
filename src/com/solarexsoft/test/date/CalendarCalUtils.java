package com.solarexsoft.test.date;

import java.util.Calendar;
import java.util.Date;

/**
 * <pre>
 *    Author: houruhou
 *    CreatAt: 09:59/2019/3/18
 *    Desc:
 * </pre>
 */

public class CalendarCalUtils {
    public static class SelectDays<K> {
        private K start;
        private K end;
        public SelectDays(){
        }

        public K getStart() {
            return start;
        }

        public void setStart(K start) {
            this.start = start;
        }

        public K getEnd() {
            return end;
        }

        public void setEnd(K end) {
            this.end = end;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("start = ").append(start).append(",end = ").append(end);
            return sb.toString();
        }
    }

    public static SelectDays<Date> getWeekStartEnd(Date clickDate) {
        SelectDays<Date> result = new SelectDays<>();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(clickDate);
        int i = calendar.get(Calendar.DAY_OF_WEEK);

        Calendar startCalendar = (Calendar) calendar.clone();
        Calendar endCalendar = (Calendar) calendar.clone();

        int sundayOffset = -(i-1);
        int saturdayOffset = 7 - i;
        startCalendar.add(Calendar.DATE, sundayOffset);
        endCalendar.add(Calendar.DATE, saturdayOffset);

        startCalendar.set(Calendar.HOUR_OF_DAY, 0);
        startCalendar.set(Calendar.MINUTE, 0);
        startCalendar.set(Calendar.SECOND, 0);
        startCalendar.set(Calendar.MILLISECOND, 0);

        endCalendar.set(Calendar.HOUR_OF_DAY, 0);
        endCalendar.set(Calendar.MINUTE, 0);
        endCalendar.set(Calendar.SECOND, 0);
        endCalendar.set(Calendar.MILLISECOND, 0);

        result.setStart(startCalendar.getTime());
        result.setEnd(endCalendar.getTime());
        return result;
    }

    public static SelectDays<Date> getMonthStartEnd(Date clickDate) {
        SelectDays<Date> result = new SelectDays<>();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(clickDate);
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int lastday = getDaysForMonth(month, year);

        Calendar startCalendar = (Calendar) calendar.clone();
        Calendar endCalendar = (Calendar) calendar.clone();
        startCalendar.set(Calendar.DAY_OF_MONTH, 1);
        endCalendar.set(Calendar.DAY_OF_MONTH, lastday);

        startCalendar.set(Calendar.HOUR_OF_DAY, 0);
        startCalendar.set(Calendar.MINUTE, 0);
        startCalendar.set(Calendar.SECOND, 0);
        startCalendar.set(Calendar.MILLISECOND, 0);

        endCalendar.set(Calendar.HOUR_OF_DAY, 0);
        endCalendar.set(Calendar.MINUTE, 0);
        endCalendar.set(Calendar.SECOND, 0);
        endCalendar.set(Calendar.MILLISECOND, 0);

        result.setStart(startCalendar.getTime());
        result.setEnd(endCalendar.getTime());
        return result;
    }

    public static int getDaysForMonth(int month, int year) {
        // month is 0-based
        if (month == 1) {
            boolean is29Feb = false;

            if (year < 1582)
                is29Feb = (year < 1 ? year + 1 : year) % 4 == 0;
            else if (year > 1582)
                is29Feb = year % 4 == 0 && (year % 100 != 0 || year % 400 == 0);

            return is29Feb ? 29 : 28;
        }

        if (month == 3 || month == 5 || month == 8 || month == 10)
            return 30;
        else
            return 31;
    }
}

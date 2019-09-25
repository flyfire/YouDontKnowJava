package com.solarexsoft.jcip;

import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;

/**
 * Created by houruhou on 2018/7/17.
 */
public class Main {
    public static void main(String[] args) {
        HashSet<URL> set = new HashSet<>();
        try {
            URL baidu = new URL("http://www.baidu.com");
            set.add(baidu);
            URL tmp = new URL("http://www.baidu.com");
            System.out.println(set.contains(tmp));;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
            date = format.parse("2018-07-03 00:00:00");
            System.out.println(format.format(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}

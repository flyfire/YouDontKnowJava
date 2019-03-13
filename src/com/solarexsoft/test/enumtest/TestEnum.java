package com.solarexsoft.test.enumtest;

/**
 * Created by houruhou on 2019/2/22.
 * Desc:
 */
public class TestEnum {
    enum Types{
        Food,
        Sport,
        Sleep;
    }

    public static void main(String[] args) {
        System.out.println(Types.Food.name());
        System.out.println(Types.Sport.name());
        System.out.println(Types.Sleep.name());
    }
}

package com.solarexsoft.test;

/**
 * Created by houruhou on 2019/1/7.
 * Desc:
 */
public class TestDivider {
    public static void main(String[] args) {
        int minY = -2000;
        float originMinY = -2350.4f;
        if (originMinY < -2000) {
            minY = (((int)originMinY / 1000) - 1) * 1000;
        }
        int maxY = 2000;
        float originMaxY = 2350.3f;
        if (originMaxY > 2000) {
            maxY = (((int)originMaxY/1000) + 1)*1000;
        }
        System.out.println("minY = " + minY + ",maxY = " + maxY);
    }
}

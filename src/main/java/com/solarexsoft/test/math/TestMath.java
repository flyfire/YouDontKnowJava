package com.solarexsoft.test.math;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Created by houruhou on 2019/7/12.
 * Desc:
 */
public class TestMath {
    public static void main(String[] args) {
        double tmp = 674.461;
        double v = new BigDecimal(tmp).setScale(0, RoundingMode.HALF_UP).doubleValue();
        long l = Math.round(v);
        System.out.println("v = " + v);
        System.out.println("l = " + l);
    }
}

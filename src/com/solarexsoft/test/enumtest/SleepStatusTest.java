package com.solarexsoft.test.enumtest;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by houruhou on 2019/3/21.
 * Desc:
 */
class SleepStatusTest {
    @Test
    public void testSleep() {
        System.out.println(SleepStatus.valueOf("terrible").ordinal());
    }
}
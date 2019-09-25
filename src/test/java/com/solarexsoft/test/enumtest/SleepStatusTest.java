package com.solarexsoft.test.enumtest;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by houruhou on 2019/9/25.
 * Desc:
 */
public class SleepStatusTest {
    @Test
    public void testSleep() {
        System.out.println(SleepStatus.valueOf("terrible").ordinal());
    }
}
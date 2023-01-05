package com.solarexsoft.test;

import java.io.File;

/*
 * Created by Solarex on 2022/12/29 14:20
 */
public class TestFile {
    public static void main(String args[]) {
        File file = new File("/sdcard", "DCIM/" + System.currentTimeMillis() + ".jpg");
        System.out.println(file.getAbsolutePath());
    }
}

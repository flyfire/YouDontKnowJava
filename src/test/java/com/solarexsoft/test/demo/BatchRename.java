package com.solarexsoft.test.demo;

import java.io.File;
import java.util.Objects;

/**
 * Created by Solarex at 10:52/2020/10/9
 * Desc:
 */
public class BatchRename {
    public static void main(String[] args) {
        File f = new File(".");
        for (File file : Objects.requireNonNull(f.listFiles())) {
            if (file.getName().startsWith("2")) {
                String name = file.getName().substring(11);
                file.renameTo(new File(name));
            }
        }
    }
}

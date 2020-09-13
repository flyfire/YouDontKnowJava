package com.solarexsoft.hack;

/**
 * Created by Solarex at 11:48/2020/9/13
 * Desc:
 */
public class TwoMains {
    public static void main(String[] args) {
        System.out.println("main->0");
        main(args);
    }

    public static void main(String[] args) {
        System.out.println("main->1");
    }
}

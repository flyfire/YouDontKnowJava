package com.solarexsoft.test.loader;

import java.util.Random;

/**
 * Created by houruhou on 17/09/2017.
 */
class FinalTest {
    //x在编译器已经确定，不会导致FinalTest的初始化 static block不会被打印
    public static final int x = 6 / 3;

    //x需要在运行时确定，会导致FinalTest的初始化，static block会打印
    //    public static final int x = new Random().nextInt();
    static {
        System.out.println("FinalTest static block");
    }
}

public class TestInit {
    public static void main(String[] args){
        System.out.println(FinalTest.x);
    }
}

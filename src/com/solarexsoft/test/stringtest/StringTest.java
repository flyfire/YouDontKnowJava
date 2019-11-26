package com.solarexsoft.test.stringtest;

/**
 * Created by houruhou on 2019/11/26.
 * Desc:
 */
public class StringTest {
    public static void main(String[] args) {
        String abc = "abc";
        String def = "abc";
        System.out.println(System.identityHashCode(abc));
        System.out.println(System.identityHashCode(def));
        System.out.println(abc == def);
        String ghi = new String("abc");
        String jkl = new String("abc");
        String aaa = new String("abc").intern();
        System.out.println(System.identityHashCode(aaa));
        System.out.println(System.identityHashCode(ghi));
        System.out.println(System.identityHashCode(jkl));
        System.out.println(ghi == jkl);
        System.out.println(abc == ghi);
        System.out.println(abc == aaa);
        System.out.println(aaa == ghi);
        String tmp1 = new String("world").intern();
        String tmp2 = new String("world");
        System.out.println(System.identityHashCode(tmp1));
        System.out.println(System.identityHashCode(tmp2));
        System.out.println(tmp1 == tmp2);
        String test1 = new String("world").intern();
        String test2 = new String("world").intern();
        System.out.println(System.identityHashCode(test1));
        System.out.println(System.identityHashCode(test2));
        System.out.println(test1 == test2);
    }
}

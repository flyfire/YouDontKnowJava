package com.solarexsoft.test;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by houruhou on 25/05/2017.
 */
public class ArrayListTest {
    public static void main(String args[]){
        ArrayList<Integer> arrs = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            arrs.add(i+1);
        }
        Iterator<Integer> iter = arrs.iterator();
        iter.remove();
        //lastRet=-1,此时若直接再次调用iter.remove会报IllegalStateException
        //调用iter.next会重置lastRet
        iter.remove();
    }
}

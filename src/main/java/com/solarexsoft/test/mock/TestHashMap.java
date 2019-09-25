package com.solarexsoft.test.mock;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by houruhou on 2018/7/27.
 */
public class TestHashMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("solarex", "a");
        map.put("solarex", "b");
        map.put("solarex", "c");

        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> next = iterator.next();
            System.out.println(next.getKey() + " --> " + next.getValue());
        }
    }
}

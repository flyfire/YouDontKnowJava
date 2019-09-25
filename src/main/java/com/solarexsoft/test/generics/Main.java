package com.solarexsoft.test.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by houruhou on 2018/6/21.
 */
public class Main {
    public static void main(String[] args) {
        TestNode tn = new TestNode(5);
        Node n = tn;
        n.setData("Hello");
        Integer x = (Integer) n.data;
        List<Node> nodes = new ArrayList<Node>();
        nodes.add(null);
    }
}

package com.solarexsoft.test.generics;

/**
 * Created by houruhou on 2018/6/21.
 */
public class TestNode extends Node<Integer> {

    public TestNode(Integer data) {
        super(data);
    }

    @Override
    public void setData(Integer data) {
        System.out.println("------TestNode.setData-----------");
        super.setData(data);
    }
}

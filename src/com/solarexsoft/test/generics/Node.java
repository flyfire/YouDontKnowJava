package com.solarexsoft.test.generics;

/**
 * Created by houruhou on 2018/6/21.
 */
public class Node<T> {
    public T data;
    public Node(T data) {
        this.data = data;
    }
    public void setData(T data) {
        System.out.print("-----------------\nNode.setData\t");
        System.out.print(data + "\n---------------------");
        this.data = data;
    }
}

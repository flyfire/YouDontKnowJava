package com.solarexsoft.kotlinlearning;

/**
 * Created by Solarex on 2020/12/18/6:18 PM
 * Desc:
 */
public class GenericTest<T, R extends GenericTest<T, ? extends R>> {
    GenericTest(Builder<T, R> builder) {

    }
    static abstract class Builder<T, R extends GenericTest<T, ? extends R>> {
        abstract R build(T t);
    }
}

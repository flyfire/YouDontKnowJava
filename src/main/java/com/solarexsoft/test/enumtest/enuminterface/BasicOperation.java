package com.solarexsoft.test.enumtest.enuminterface;

/**
 * Created by houruhou on 2019/6/3.
 * Desc:
 */
public enum BasicOperation implements Operation{
    PLUS("+") {
        public double apply(double a, double b) { return a + b;}
    },
    MINUS("-") {
        @Override
        public double apply(double a, double b) {
            return a - b;
        }
    },
    TIMES("*") {
        @Override
        public double apply(double a, double b) {
            return a*b;
        }
    },
    DIVIDE("/") {
        @Override
        public double apply(double a, double b) {
            return a/b;
        }
    };
    private final String symbol;
    BasicOperation(String s) {
        this.symbol = s;
    }

    @Override
    public String toString() {
        return symbol;
    }
}

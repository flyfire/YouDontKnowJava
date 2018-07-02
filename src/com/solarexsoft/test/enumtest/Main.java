package com.solarexsoft.test.enumtest;

/**
 * Created by houruhou on 2018/7/2.
 */
public class Main {
    enum ExceptionHandleStrategy {
        IGNORE,
        LOG {
            @Override
            public void handle(Exception e) {
                System.out.println(e.getLocalizedMessage());
            }
        },
        THROW {
            @Override
            public void handle(Exception e) {
                throw new RuntimeException(e.getMessage());
            }
        };

        public void handle(Exception e) {
        }
    }

    public static void main(String[] args) {
        ExceptionHandleStrategy.LOG.handle(new RuntimeException("system just broken"));
    }
}

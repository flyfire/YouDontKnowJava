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
        System.out.println(ExceptionHandleStrategy.IGNORE.getClass());
        System.out.println(ExceptionHandleStrategy.LOG.getClass());
        System.out.println(ExceptionHandleStrategy.THROW.getClass());
        System.out.println(EnumWithoutMethod.A.getClass());
        System.out.println(EnumWithoutMethod.B.getClass());
        System.out.println(EnumWithoutMethod.C.getClass());
        System.out.println(EnumWithVariable.A.getClass());
        System.out.println(EnumWithVariable.B.getClass());
        System.out.println(EnumWithVariable.C.getClass());
        System.out.println(EnumWithVariable.A.name());
        System.out.println(EnumWithVariable.A.getxxx());
        ExceptionHandleStrategy.LOG.handle(new RuntimeException("system just broken"));
    }

    enum EnumWithoutMethod {
        A,
        B,
        C;
    }

    enum EnumWithVariable {
        A("wristband"),
        B("glucometer"),
        C("fit");

        private String name;
        public String getxxx() {
            return this.name;
        }

        EnumWithVariable(String name){
            this.name = name;
        }
    }
}

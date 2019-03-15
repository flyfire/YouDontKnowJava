package com.solarexsoft.test.interthreadcommucation;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Created by houruhou on 2019/3/15.
 * Desc:
 */
public class UseCallable {
    public static void main(String[] args) {
        Callable<Integer> callable = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                System.out.println("task starts");
                Thread.sleep(1000);
                int result = 0;
                for (int i = 0; i < 100; i++) {
                    result += i;
                }
                System.out.println("task finished");
                return result;
            }
        };
        FutureTask<Integer> futureTask = new FutureTask<>(callable);
        new Thread(futureTask).start();
        try {
//            Thread.sleep(2000);
            System.out.println("Before futuretask.get()");
            System.out.println("result = " + futureTask.get());
            System.out.println("after futuretask.get()");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}

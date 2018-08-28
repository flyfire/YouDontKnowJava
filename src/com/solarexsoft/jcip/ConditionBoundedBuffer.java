package com.solarexsoft.jcip;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by houruhou on 2018/8/27.
 */
public class ConditionBoundedBuffer<T> {
    private final int BUFFER_SIZE = 50;
    protected final Lock lock = new ReentrantLock();
    // 条件谓词 notFull (count < items.length)
    private final Condition notFull = lock.newCondition();
    // 条件谓词 notEmpty (count > 0)
    private final Condition notEmpty = lock.newCondition();
    private final T[] items = (T[])new Object[BUFFER_SIZE];
    private int tail,head,count;

    // 阻塞并直到notFull
    public void put(T x) throws InterruptedException {
        lock.lock();
        try {
            while (count == items.length) {
                notFull.await();
            }
            items[tail] = x;
            if (++tail == items.length) {
                tail = 0;
            }
            ++count;
            notEmpty.signal();
        } finally {
            lock.unlock();
        }
    }

    // 阻塞直到notEmpty
    public T take() throws InterruptedException {
        lock.lock();
        try {
            while (count == 0) {
                notEmpty.await();
            }
            T x = items[head];
            items[head] = null;
            if (++head == items.length) {
                head = 0;
            }
            --count;
            notFull.signal();
            return x;
        } finally {
            lock.unlock();
        }
    }
}

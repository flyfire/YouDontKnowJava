package com.solarexsoft.jcip.locks;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/**
 * Created by houruhou on 2018/8/28.
 */
public class MCSLock {
    /*
        MCS Spinlock 是一种基于链表的可扩展、高性能、公平的自旋锁，申请线程只在本地变量上自旋，直接前驱负责通知其结束自旋，从而极大地减少了不必要的处理器缓存同步的次数，降低了总线和内存的开销。
     */
    public static class MCSNode {
        volatile MCSNode next;
        volatile boolean isBlock = true; // 默认是在等待锁
    }

    volatile MCSNode queue; // 指向最后一个申请锁的MCSNode
    private static final AtomicReferenceFieldUpdater<MCSLock, MCSLock.MCSNode> UPDATER = AtomicReferenceFieldUpdater.newUpdater(MCSLock.class, MCSLock.MCSNode.class, "queue");
    
    public void lock(MCSNode currentThread) {
        MCSNode predecessor = UPDATER.getAndSet(this, currentThread);
        if (predecessor != null) {
            predecessor.next = currentThread;
            while (currentThread.isBlock) {
                ;
            }
        } else {
            // 只有一个线程在使用锁，没有前驱来通知它，所以得自己标记自己为非阻塞
            currentThread.isBlock = false;
        }
    }

    public void unlock(MCSNode currentThread) {
        if (currentThread.isBlock) { // 锁拥有者进行释放锁才有意义
            return;
        }
        if (currentThread.next == null) { // 检查是否有人排在自己后面
            if (UPDATER.compareAndSet(this, currentThread, null)) {
                // compareAndSet返回true表示确实没有人排在自己后面
                return;
            } else {
                // 突然有人排在自己后面了，可能还不知道是谁，下面是等待后续者
                while (currentThread.next == null) {
                    ;
                }
            }
        }
        currentThread.next.isBlock = false;
        currentThread.next = null;
    }

}


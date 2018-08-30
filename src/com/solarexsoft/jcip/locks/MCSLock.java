package com.solarexsoft.jcip.locks;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/**
 * Created by houruhou on 2018/8/28.
 */
public class MCSLock {
    /*
        MCS Spinlock 是一种基于链表的可扩展、高性能、公平的自旋锁，申请线程只在本地变量上自旋，直接前驱负责通知其结束自旋，从而极大地减少了不必要的处理器缓存同步的次数，降低了总线和内存的开销。
     */
    volatile MCSNode queue; // 指向最后一个申请锁的MCSNode
    private static final AtomicReferenceFieldUpdater UPDATER = AtomicReferenceFieldUpdater.newUpdater(MCSLock.class, MCSNode.class, "queue");
    


}
class MCSNode {
    volatile MCSNode next;
    volatile boolean isBlock = true; // 默认是在等待锁
}


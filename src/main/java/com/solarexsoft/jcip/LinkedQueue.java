package com.solarexsoft.jcip;

import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by houruhou on 2018/8/28.
 */
public class LinkedQueue<E> {
    private static class Node<E> {
        final E item;
        final AtomicReference<Node<E>> next;

        public Node(E item, Node<E> next) {
            this.item = item;
            this.next = new AtomicReference<>(next);
        }
    }

    private final Node<E> dummy = new Node<E>(null, null);
    private final AtomicReference<Node<E>> head = new AtomicReference<>(dummy);
    private final AtomicReference<Node<E>> tail = new AtomicReference<>(dummy);

    public boolean put(E item) {
        Node<E> newNode = new Node<>(item, null);
        while (true) {
            Node<E> curTail = tail.get();
            Node<E> curTailNext = curTail.next.get();
            if (curTail == tail.get()) {
                if (curTailNext != null) {
                    tail.compareAndSet(curTail, curTailNext);
                } else {
                    if (curTail.next.compareAndSet(null, newNode)) {
                        tail.compareAndSet(curTail, newNode);
                        return true;
                    }
                }
            }
        }

    }
}

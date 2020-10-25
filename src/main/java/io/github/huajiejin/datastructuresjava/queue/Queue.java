package io.github.huajiejin.datastructuresjava.queue;

import io.github.huajiejin.datastructuresjava.List;
import io.github.huajiejin.datastructuresjava.linkedlist.DoublyLinkedListWithVirtualNode;

public class Queue<E> {

    private List<E> elements = new DoublyLinkedListWithVirtualNode<>();

    public void enQueue(E e) {
        elements.add(e);
    }

    public E deQueue() {
        return elements.size() > 0 ? elements.get(elements.size()-1) : null;
    }

    public E front() {
        return elements.get(0);
    }

}

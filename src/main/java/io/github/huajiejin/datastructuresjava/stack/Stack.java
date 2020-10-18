package io.github.huajiejin.datastructuresjava.stack;

import io.github.huajiejin.datastructuresjava.List;
import io.github.huajiejin.datastructuresjava.linkedlist.DoublyLinkedListWithVirtualNode;

public class Stack<E> {

    DoublyLinkedListWithVirtualNode<E> elements = new DoublyLinkedListWithVirtualNode<>();

    public boolean push(E e) {
        elements.add(e);
        return true;
    }

    public E peek() {
        return elements.getLast();
    }

    public E pop() {
        if (elements.size() < 1) return null;
        E last = elements.getLast();
        elements.remove(elements.size() - 1);
        return last;
    }

}

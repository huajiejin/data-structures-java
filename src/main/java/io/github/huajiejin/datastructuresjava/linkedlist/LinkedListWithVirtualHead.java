package io.github.huajiejin.datastructuresjava.linkedlist;

import io.github.huajiejin.datastructuresjava.AbstractList;

public class LinkedListWithVirtualHead<E> extends AbstractList<E> {
    private Node<E> firstNode = new Node<E>(null, null, null);

    @Override
    public void insertAt(int index, E element) {
        rangeCheckForInsert(index);
        Node<E> prevNode = index == 0 ? firstNode : findNodeByIndex(index-1);
        Node<E> nextNode = prevNode.next;
        prevNode.next = new Node(prevNode, element, nextNode);
        if (nextNode != null) {
            nextNode.prev = prevNode.next;
        }
        size++;
    }

    @Override
    public void remove(int index) {
        rangeCheck(index);
        Node<E> prevNode = index == 0 ? firstNode : findNodeByIndex(index-1);
        if (prevNode.next != null) {
            prevNode.next = prevNode.next.next;
            if (prevNode.next != null) {
                prevNode.next.prev = prevNode;
            }
        }
        size--;
    }

    @Override
    public E get(int index) {
        rangeCheck(index);
        return findNodeByIndex(index).element;
    }

    @Override
    public E set(int index, E element) {
        Node<E> node = findNodeByIndex(index);
        E oldElement = node.element;
        node.element = element;
        return oldElement;
    }

    @Override
    public int indexOf(E element) {
        int index = ELEMENT_NOT_FOUND;
        int i = 0;
        Node<E> node = firstNode.next;
        while (index == ELEMENT_NOT_FOUND && node != null) {
            if ((node.element == null && element == null) || (node.element != null && node.element.equals(element))) {
                index = i;
            } else {
                i++;
                node = node.next;
            }
        }
        return index;
    }

    @Override
    public void clear() {
        firstNode.next = null;
        size = 0;
    }

    private static class Node<E> {
        Node<E> prev;
        E element;
        Node<E> next;

        public Node(Node<E> prev, E element, Node<E> next) {
            this.prev = prev;
            this.element = element;
            this.next = next;
        }
    }

    private Node<E> findNodeByIndex(int index) {
        Node<E> node = firstNode.next;
        for (int i=0; i<index; i++) {
            node = node.next;
        }
        return node;
    }
}

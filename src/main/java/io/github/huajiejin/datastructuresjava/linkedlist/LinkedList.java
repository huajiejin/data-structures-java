package io.github.huajiejin.datastructuresjava.linkedlist;

import io.github.huajiejin.datastructuresjava.AbstractList;

public class LinkedList<E> extends AbstractList<E> {
    private Node<E> firstNode;

    @Override
    public void insertAt(int index, E element) {
        if (index == 0) {
            firstNode = new Node(null, element, firstNode);
            if (size != 0) {
                firstNode.next.prev = firstNode;
            }
        } else {
            Node<E> prevNode = findNodeByIndex(index-1);
            Node<E> nextNode = prevNode.next;
            prevNode.next = new Node(prevNode, element, nextNode);
            if (nextNode != null) {
                nextNode.prev = prevNode.next;
            }
        }
        size++;
    }

    @Override
    public void remove(int index) {
        Node<E> node = findNodeByIndex(index);
        if (index == 0) {
            firstNode = null;
        } else {
            node.prev.next = node.next;
            if (node.next != null) {
                node.next.prev = node.prev;
            }
        }
        size--;
    }

    @Override
    public E get(int index) {
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
        Node<E> node = firstNode;
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
        firstNode = null;
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
        rangeCheck(index);
        Node<E> node = firstNode;
        for (int i=0; i<index; i++) {
            node = node.next;
        }
        return node;
    }
}

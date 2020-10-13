package io.github.huajiejin.datastructuresjava.linkedlist;

import io.github.huajiejin.datastructuresjava.AbstractList;

public class DoublyLinkedListWithVirtualNode<E> extends AbstractList<E> {
    private Node<E> firstVirtualNode = new Node<E>(null, null, null);
    private Node<E> lastVirtualNode = new Node<E>(null, null, null);

    public DoublyLinkedListWithVirtualNode() {
        firstVirtualNode.next = lastVirtualNode;
        lastVirtualNode.prev = firstVirtualNode;
    }

    @Override
    public void insertAt(int index, E element) {
        rangeCheckForInsert(index);
        Node<E> prevNode = findNodeByIndex(index-1);
        Node<E> nextNode = prevNode.next;
        prevNode.next = new Node(prevNode, element, nextNode);
        nextNode.prev = prevNode.next;
        size++;
    }

    @Override
    public void remove(int index) {
        rangeCheck(index);
        Node<E> prevNode = findNodeByIndex(index-1);
        prevNode.next = prevNode.next.next;
        prevNode.next.prev = prevNode;
        size--;
    }

    @Override
    public E get(int index) {
        rangeCheck(index);
        return findNodeByIndex(index).element;
    }

    @Override
    public E set(int index, E element) {
        rangeCheck(index);
        Node<E> node = findNodeByIndex(index);
        E oldElement = node.element;
        node.element = element;
        return oldElement;
    }

    @Override
    public int indexOf(E element) {
        int index = ELEMENT_NOT_FOUND;
        int i = 0;
        Node<E> node = firstVirtualNode.next;
        while (index == ELEMENT_NOT_FOUND && !lastVirtualNode.equals(node)) {
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
        firstVirtualNode.next = lastVirtualNode;
        lastVirtualNode.prev = firstVirtualNode;
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
        Node<E> node;
        if (index == -1) {
            return firstVirtualNode;
        }
        else if (index == size) {
            return lastVirtualNode;
        }
        else if (index < (size >> 1)) {
            // start from 0
            node = firstVirtualNode.next;
            for (int i=0; i<index; i++) {
                node = node.next;
            }
        } else {
            // start from size - 1
            node = lastVirtualNode.prev;
            for (int i=size-1; i>index; i--) {
                node = node.prev;
            }
        }
        return node;
    }
}

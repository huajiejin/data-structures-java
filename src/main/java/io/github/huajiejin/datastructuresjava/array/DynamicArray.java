package io.github.huajiejin.datastructuresjava.array;

import io.github.huajiejin.datastructuresjava.AbstractList;

import java.util.RandomAccess;

// ArrayList
public class DynamicArray<E> extends AbstractList<E> implements RandomAccess {
    private static final int DEFAULT_CAPACITY = 10;

    private E[] elements;

    public DynamicArray(int capacity) {
        capacity = (capacity < 0) ? DEFAULT_CAPACITY : capacity;
        // references.
        elements = (E[]) new Object[capacity];
    }

    public DynamicArray() {
        this(DEFAULT_CAPACITY);
    }

    @Override
    public void insertAt(int index, E element) {
        rangeCheckForInsert(index);
        ensureCapacity(size+1);
        for (int i = size; i > index; i--) {
            elements[i] = elements[i-1];
        }
        elements[index] = element;
        size++;
    }

    @Override
    public void remove(int index) {
        rangeCheck(index);
        if(index+1 < size) {
            for (int i = index; i < size; i++) {
                elements[i] = elements[i+1];
            }
        }
        size--;
        elements[size] = null;
    }

    @Override
    public E get(int index) {
        rangeCheck(index);
        return elements[index];
    }

    @Override
    public E set(int index, E element) {
        rangeCheck(index);
        E old = elements[index];
        elements[index] = element;
        return old;
    }

    @Override
    public int indexOf(E element) {
        for(int i=0; i<size; i++) {
            if (element == null && elements[i] == null) return i;
            if (element != null && element.equals(elements[i])) return i;
        }
        return ELEMENT_NOT_FOUND;
    }

    @Override
    public void clear() {
        for (int i=0; i<size; i++) {
            elements[i] = null;
        }
        size = 0;
    }

    private void ensureCapacity(int capacity) {
        int oldCapacity = elements.length;
        if (oldCapacity >= capacity) return;
        // 1.5 times.
        int newCapacity = oldCapacity + (oldCapacity >> 1) + 1;
        E[] newElements = (E[]) new Object[newCapacity];
        for (int i=0; i<size; i++) {
            newElements[i] = elements[i];
        }
        elements = newElements;
    }
}

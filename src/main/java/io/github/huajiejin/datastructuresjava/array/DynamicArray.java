package io.github.huajiejin.datastructuresjava.array;

import java.util.Arrays;

public class DynamicArray<E> {
    private int size;

    private E[] elements;

    private static final int DEFAULT_CAPACITY = 2;

    public DynamicArray(int capacity) {
        capacity = (capacity < DEFAULT_CAPACITY) ? DEFAULT_CAPACITY : capacity;
        // references.
        elements = (E[]) new Object[capacity];
    }

    public DynamicArray() {
        this(DEFAULT_CAPACITY);
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contains(E element) {
        return false;
    }

    public void add(E element) {
        ensureCapacity(size+1);
        elements[size++] = element;
    }

    public void add(int index, E element) {
        checkIndex(index);
        ensureCapacity(size+1);
        for (int i = size; i > index; i--) {
            elements[i] = elements[i-1];
        }
        elements[index] = element;
        size++;
    }

    public void remove(int index) {
        checkIndex(index);
        for (int i = index; i < size; i++) {
            elements[i] = elements[i+1];
        }
        size--;
        elements[size] = null;
    }

    public E get(int index) {
        checkIndex(index);
        return elements[index];
    }

    public E set(int index, E element) {
        checkIndex(index);
        E old = elements[index];
        elements[index] = element;
        return old;
    }

    public int indexOf(E element) {
        for(int i=0; i<size; i++) {
            if (element == null && elements[i] == null) return i;
            if (element != null && element.equals(elements[i])) return i;
        }
        return -1;
    }

    public void clear() {
        for (int i=0; i<size; i++) {
            elements[i] = null;
        }
        size = 0;
    }

    private void checkIndex(int index) {
        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("index ("+index+") should be greater than 0 or equal to 0 and less than size ("+size+").");
        }
    }

    private void ensureCapacity(int capacity) {
        int oldCapacity = elements.length;
        if (oldCapacity >= capacity) return;
        // 1.5 times.
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        E[] newElements = (E[]) new Object[newCapacity];
        for (int i=0; i<size; i++) {
            newElements[i] = elements[i];
        }
        elements = newElements;
    }

    @Override
    public String toString() {
        return "DynamicArray{" +
                "size=" + size +
                ", elements=" + Arrays.toString(elements) +
                '}';
    }

    public static void main(String[] args) {
        DynamicArray<Integer> list = new DynamicArray<>(3);
        boolean isEmpty = list.isEmpty();
        list.add(1);
        list.add(2);
        list.add(3);
//        list.add(1,22);
//        list.set(0, 0);
//        list.set(1, 1);
//        list.remove(0);
//        list.remove(0);
        System.out.println("list: " + list);
        list.clear();
        list.add(4);
        list.add(4);
        list.add(4);
        System.out.println("list: " + list);
        list.get(1);
        System.out.println("indexOf 0"+list.indexOf(0));
//        System.gc();
    }
}

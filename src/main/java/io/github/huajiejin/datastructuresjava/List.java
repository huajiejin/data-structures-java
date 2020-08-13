package io.github.huajiejin.datastructuresjava;

public interface List<E> {
    int ELEMENT_NOT_FOUND = -1;

    int size();

    boolean isEmpty();

    boolean contains(E element);

    void add(E element);

    void insertAt(int index, E element);

    void remove(int index);

    E get(int index);

    E set(int index, E element);

    int indexOf(E element);

    void clear();
}

package io.github.huajiejin.datastructuresjava;

public abstract class AbstractList<E> implements List<E> {

    protected int size;

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(E element) {
        return indexOf(element) != ELEMENT_NOT_FOUND;
    }

    @Override
    public void add(E element) {
        insertAt(size, element);
    }

    protected void outOfBounds(int index) {
        throw new IndexOutOfBoundsException("index ("+index+") should be greater than 0 or equal to 0 and less than size ("+size+").");
    }

    protected void rangeCheck(int index) {
        if(index < 0 || index >= size) {
            outOfBounds(index);
        }
    }

    protected void rangeCheckForInsert(int index) {
        if(index < 0 || index > size) {
            outOfBounds(index);
        }
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println(getClass().getSimpleName()+" destroyed");
        super.finalize();
    }
}

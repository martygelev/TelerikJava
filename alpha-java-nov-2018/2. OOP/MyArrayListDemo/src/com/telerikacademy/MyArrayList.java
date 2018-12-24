package com.telerikacademy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

//public class MyArrayList<E extends Comparable<E>> implements Iterable<E> {
public class MyArrayList<E> implements Iterable<E> {
    private Object[] data;
    private int capacity, size;

    public MyArrayList() {
        capacity = 5;
        size = 0;
        data = new Object[capacity];
    }

    public int size() {
        return size;
    }

    public void addElement(E element) {
        if (size == capacity) {
            resizeData();
        }
        data[size++] = element;
    }

    public E getElement(int index) {
        validateIndex(index);
        return (E) data[index];
    }

    public void setElement(int index, E element) {
        validateIndex(index);
        data[index] = element;
    }

    public int findElement(E element) {
        for (int i = 0; i < size; i++) {
            if (((E) data[i]).equals(element)) {
                return i;
            }
        }
        return -1;
    }

//    When E extends Comparable
//    public E findMin() {
//        if (size == 0) {
//            throw new NoSuchElementException();
//        }
//        E min = (E) data[0];
//        for (int i = 0; i < size; i++) {
//            if (((E) data[i]).compareTo(min) < 0) {
//                min = (E) data[i];
//            }
//        }
//        return min;
//    }

    public E findMin(Comparator<E> comp) {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        E min = (E) data[0];
        for (int i = 0; i < size; i++) {
            if (comp.compare((E) data[i], min) < 0) {
                min = (E) data[i];
            }
        }
        return min;
    }

    private void resizeData() {
        capacity *= 2;
        data = Arrays.copyOf(data, capacity);
    }

    private void validateIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public Iterator<E> iterator() {
        // with nested class (better encapsulation)
        return new MyIterator();

        // with external class
        //return new MyIterator2<>(this);
    }

    private class MyIterator implements Iterator<E> {
        int cursor;

        MyIterator() {
            cursor = 0;
        }

        @Override
        public boolean hasNext() {
            return cursor < size;
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return (E) data[cursor++];
        }
    }
}

class MyIterator2<E> implements Iterator<E> {
    private MyArrayList<E> myArrayList;
    private int cursor;

    MyIterator2(MyArrayList<E> myArrayList) {
        this.myArrayList = myArrayList;
        cursor = 0;
    }

    @Override
    public boolean hasNext() {
        return cursor < myArrayList.size();
    }

    @Override
    public E next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return myArrayList.getElement(cursor++);
    }
}

package com.telerikacademy;

import java.util.Arrays;

public class MyIntArrayList {
    private int capacity;
    private int size;
    private int[] data;

    public MyIntArrayList() {
        this.capacity = 5;
        this.size = 0;
        this.data = new int[capacity];
    }

    public void add(int x) {
        if (size == capacity) {
            capacity *= 2;
            data = Arrays.copyOf(data, capacity);
        }
        data[size] = x;
        size++;
    }

    public int elementAt(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return data[index];
    }
}
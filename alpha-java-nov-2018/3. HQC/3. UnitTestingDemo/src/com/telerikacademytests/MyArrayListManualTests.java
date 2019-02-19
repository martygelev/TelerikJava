package com.telerikacademytests;

import com.telerikacademy.MyArrayList;

public class MyArrayListManualTests {
    public static void main(String[] args) {
        newArrayListIsEmpty();
        arrayListWithOneElementHasSize1();
        getElementThrowsExceptionWhenElementNotExist();
    }

    public static void newArrayListIsEmpty() {
        MyArrayList<Integer> list = new MyArrayList<>();

        if (list.size() != 0) {
            System.out.println("[ERROR] New array list is not empty!");
        }
    }

    public static void arrayListWithOneElementHasSize1() {
        MyArrayList<Integer> list = new MyArrayList<>();
        list.addElement(1);

        if (list.size() != 1) {
            System.out.println("[ERROR] Array list with one element has size != 1!");
        }
    }

    public static void getElementThrowsExceptionWhenElementNotExist() {
        MyArrayList<Integer> list = new MyArrayList<>();
        boolean exceptionThrown = false;

        try {
            list.getElement(0);
        } catch (IndexOutOfBoundsException e) {
            exceptionThrown = true;
        }

        if (!exceptionThrown) {
            System.out.println("[ERROR] Get element not throw exception when element not exist!");
        }
    }
}

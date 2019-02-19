package com.telerikacademy;

public class Main {

    public static void main(String[] args) {
        //ArrayList
        MyArrayList<Integer> myArrayList = new MyArrayList<>();
        myArrayList.addElement(5);
        myArrayList.addElement(3);
        myArrayList.addElement(7);
        myArrayList.addElement(66);
        myArrayList.addElement(8);
        myArrayList.addElement(6);
        System.out.println(myArrayList.size());

        System.out.println(myArrayList.getElement(3));

        myArrayList.setElement(3, 9);
        System.out.println(myArrayList.getElement(3));

        System.out.println(myArrayList.findElement(7));

        System.out.println(myArrayList.findMin(Integer::compareTo));

        for (Integer i : myArrayList) {
            System.out.print(i);
        }

        System.out.println();
        for (Integer i : myArrayList) {
            System.out.print(i);
        }
    }
}

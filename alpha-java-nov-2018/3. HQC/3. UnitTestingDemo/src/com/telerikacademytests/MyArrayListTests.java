package com.telerikacademytests;

import com.telerikacademy.MyArrayList;
import org.junit.*;

public class MyArrayListTests {
    @Test
    public void size_Should_Return0_When_NewInstance() {
        // Arrange
        MyArrayList<Integer> list = new MyArrayList<>();

        // Act
        int actualSize = list.size();

        // Assert
        Assert.assertEquals(
                "New array list is not empty!",
                0,
                actualSize);
    }

    @Test
    public void size_Should_Return1_When_OneElementExists() {
        MyArrayList<Integer> list = new MyArrayList<>();
        list.addElement(1);

        Assert.assertEquals(
                "Array list with one element has size != 1!",
                1,
                list.size());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void getElement_Should_ThrowIndexOutOfBound_When_ElementNotExist() {
        // Arrange
        MyArrayList<Integer> list = new MyArrayList<>();

        // Act
        list.getElement(0);
    }
}

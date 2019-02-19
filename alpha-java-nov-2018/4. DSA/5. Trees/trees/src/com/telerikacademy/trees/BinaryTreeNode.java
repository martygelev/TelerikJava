package com.telerikacademy.trees;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeNode {
    BinaryTreeNode left, right;
    int value;

    public BinaryTreeNode(int value) {
        this.value = value;
    }

    // DFS different styles
    // Left -> Node -> Right
    public void printInOrder() {
        if (left != null) {
            left.printInOrder();
        }

        System.out.print(value + " ");

        if (right != null) {
            right.printInOrder();
        }
    }

    // DFS different styles
    // Top -> Bottom -> Left -> Right
    public void printPreOrder() {
        System.out.print(value + " ");

        if (left != null) {
            left.printPreOrder();
        }

        if (right != null) {
            right.printPreOrder();
        }
    }

    // DFS different styles
    // Bottom -> Top -> Left -> Right
    public void printPostOrder() {
        if (left != null) {
            left.printPostOrder();
        }

        if (right != null) {
            right.printPostOrder();
        }

        System.out.print(value + " ");
    }

    //binary search tree - search - O(log n)
    // for every day normal binary tree just search - O(n)
    public boolean search(int value) {
        if (this.value == value){
            return  true;
        }

        if (this.value > value && this.left != null){
            return this.left.search(value);
        }

        if (this.value < value && this.right != null){
            return this.right.search(value);
        }

        return false;
    }

    public void bfs() {
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.offer(this);

        while (!queue.isEmpty()) {
            BinaryTreeNode current = queue.poll();
            System.out.print(current.value + " ");
            if (current.left != null) {
                queue.offer(current.left);
            }
            if (current.right != null) {
                queue.offer(current.right);
            }
        }
    }
}

package com.telerikacademy.trees;

import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode t1 = new TreeNode(2);
        root.children = new LinkedList<>();
        root.children.add(new TreeNode(5));
        root.children.add(t1);
        root.children.add(new TreeNode(1));
        t1.children = new LinkedList<>();
        t1.children.add(new TreeNode(4));
        TreeNode t2 = new TreeNode(10);
        t1.children.add(t2);
        t2.children = new LinkedList<>();
        t2.children.add(new TreeNode(6));

//        root.dfs();
//        System.out.println("");
//        root.bfs();

        BinaryTreeNode broot = new BinaryTreeNode(5);
        BinaryTreeNode five = new BinaryTreeNode(5);
        broot.left = five;
        BinaryTreeNode two = new BinaryTreeNode(2);
        BinaryTreeNode ten = new BinaryTreeNode(10);
        five.left = two;
        broot.right = ten;
        BinaryTreeNode four = new BinaryTreeNode(4);
        two.left = new BinaryTreeNode(1);
        two.right = four;
        four.left = new BinaryTreeNode(3);
        ten.left = new BinaryTreeNode(6);

        broot.printInOrder();
        System.out.println("");
        System.out.println(broot.search(-11));
    }
}

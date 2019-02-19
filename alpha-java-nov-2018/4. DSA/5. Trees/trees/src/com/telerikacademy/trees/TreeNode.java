package com.telerikacademy.trees;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeNode {
    int value;
    List<TreeNode> children = new LinkedList<>();

    public TreeNode(int value) {
        this.value = value;
    }

    public void setChildren(List<TreeNode> children) {
        this.children = new LinkedList<>(children);
    }

    public int getValue() {
        return value;
    }

    public void addNode(TreeNode child) {
        children.add(child);
    }

    @Override
    public String toString() {
        return Integer.toString(value);
    }

    public void dfs() {
        System.out.print(value + " ");

        if (children == null || children.isEmpty()) {
            return;
        }

        for (TreeNode child : children) {
            child.dfs();
        }
    }

    public void bfs() {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(this);

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            System.out.print(current.value + " ");

            for (TreeNode child : current.children) {
                queue.offer(child);
            }
        }
    }

    public int getHeight() {
        if (children == null || children.size() == 0) {
            return 1;
        } else {
            int maxDepth = 0;

            for (TreeNode child : children) {
                maxDepth = Math.max(maxDepth, child.getHeight());
            }

            return maxDepth + 1;
        }
    }

    public void printBfs() {
        for (int i = 0; i < getHeight(); i++) {
            printAtLevel(i);
            System.out.println(System.lineSeparator());
        }
    }

    private void printAtLevel(int level) {
        if (level < 0) {
            return;
        }

        if (level == 0) {
            System.out.print(value + " ");
        } else {
            for (TreeNode child : children) {
                child.printAtLevel(level - 1);
            }
        }
    }
}
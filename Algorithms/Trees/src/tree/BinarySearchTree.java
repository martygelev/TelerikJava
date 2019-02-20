package tree;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class BinarySearchTree implements TraversableBFS, TraversableDFS {
    private Node root;

    public BinarySearchTree() {
        this.root = null;
    }

    public boolean isBinarySearchTree() {
        return isBstRecursive(root, Integer.MAX_VALUE, Integer.MAX_VALUE);
    }

    public Node search(int x) {
        return searchRecursive(x, root);
    }

    public Node insert(int x) {
        return insertRecursive(root, x);
    }

    public Node delete(int x) {
        return deleteRecursive(x, root);
    }

    private Node searchRecursive(int x, Node node) {
        if (node.value == x) {
            return node;
        }

        if (x < node.value) {
            return searchRecursive(x, node.left);
        } else if (x > node.value) {
            return searchRecursive(x, node.right);
        }
        return null;
    }

    private Node insertRecursive(Node current, int x) {
        if (current == null) {
            return new Node(x);
        }

        if (current.value < x) {
            current.right = insertRecursive(current.right, x);
        } else if (current.value < x) {
            current.left = insertRecursive(current.left, x);
        }
        return current;
    }

    private Node deleteRecursive(int x, Node currentNode) {
        if (x == currentNode.value) {
            if (currentNode.left == null && currentNode.right == null) {
                return null;
            } else if (currentNode.left == null) {
                currentNode = currentNode.right;
                currentNode.right = null;
            } else if (currentNode.right == null) {
                currentNode = currentNode.left;
                currentNode.left = null;
            } else {
                Node smallestNode = smallestNode(currentNode.right); // because smallestNode take rightTree
                currentNode.value = smallestNode.value;
                currentNode.right = deleteRecursive(smallestNode.value, currentNode.right);
            }
            return currentNode;
        }
        if (x < currentNode.value) {
            currentNode.left = deleteRecursive(x, currentNode.left);
        } else {
            currentNode.right = deleteRecursive(x, currentNode.right);
        }
        return currentNode;
    }

    private Node smallestNode(Node rightTree) {
        if (rightTree.left == null) {
            return rightTree;
        } else return smallestNode(rightTree.left);
    }

    private boolean isBstRecursive(Node node, int minValue, int maxValue) {
        if (node == null) {
            return true;
        }
        return node.value >= minValue && node.value < maxValue
                && isBstRecursive(node.right, minValue, node.value)
                && isBstRecursive(node.right, node.value, maxValue);

    }

    @Override
    public void bfs() {
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();
            if (currentNode == null) {
                throw new AssertionError();
            }
            System.out.printf("%d ", currentNode.value);
            if (currentNode.left != null) {
                queue.add(currentNode.left);
            }
            if (currentNode.right != null) {
                queue.add(currentNode.right);
            }
        }
    }

    @Override
    public void dfsInOrder() {
        dfsInOrderUtil(root);
    }

    public void dfsInOrderUtil(Node current) {
        if (current == null) return;
        dfsInOrderUtil(current.left);
        System.out.printf("%d ", current.value);
        dfsInOrderUtil(current.right);
    }


    public void dfsPostOrderUtil(Node current) {
        if (current == null) return;
        dfsInOrderUtil(current.left);
        dfsInOrderUtil(current.right);
        System.out.printf("%d ", current.value);

    }

    @Override
    public void dfsPreOrder() {
        if (root == null) return;
        Stack<Node> stack = new Stack<>();

        stack.push(root);

        while (!stack.isEmpty()) {
            Node current = stack.pop();
            System.out.printf("%d ", current.value);

            if (current.left != null) {
                stack.push(current.left);
            }
            if (current.right != null) {
                stack.push(current.right);
            }
        }
    }

    @Override
    public void dfsPostOrder() {
        dfsPostOrderUtil(root);
    }
}

package tree;

import javax.swing.tree.TreeNode;
import java.util.Stack;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

        tree.insert(3);
        tree.insert(4);
        tree.insert(6);
        tree.insert(11);
        tree.insert(43);
        tree.insert(12);
        tree.insert(134);
        tree.insert(5);
        tree.insert(11);
        tree.insert(3);

        //System.out.println(tree.search(43).value);
        System.out.print("Is it Binary Tree ? -> ");
        System.out.println(tree.isBinarySearchTree());
        //tree.delete(6);
        // System.out.println(tree.search(6).value);
        //treeMap.sea
        System.out.println("\nPost-order DFS - recursive: ");
        tree.dfsPostOrder();

        System.out.println("BFS: ");
        tree.bfs();

        System.out.println("\nPre-order DFS using a stack: ");
        tree.dfsPreOrder();

        System.out.println("\nIn-order DFS - recursive: ");
        tree.dfsInOrder();

        tree.insert(55555);
        tree.bfs();
        System.out.println(tree.search(55555).value);

    }
}



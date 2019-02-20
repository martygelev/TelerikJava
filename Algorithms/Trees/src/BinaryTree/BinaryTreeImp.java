package BinaryTree;

public class BinaryTreeImp {
    Node root;
    //inserting elements

    public void add(int value) {
        root = addRecursive(root, value);
    }

    public boolean containsNode(int value) {
        return containsNodeRecursive(root, value);
    }

    private boolean containsNodeRecursive(Node current, int value) {
        if (current == null) {
            return false;
        }
        if (current.value == value) {
            return true;
        }
        return current.value > value ? containsNodeRecursive(current.right, value) : containsNodeRecursive(current.left, value);

    }

    private Node addRecursive(Node currentNode, int value) {

        if (currentNode == null) {
            return new Node(value);
        }
        if (value > currentNode.value) {
            return addRecursive(currentNode.right, value);
        } else if (value < currentNode.value) {
            return addRecursive(currentNode.left, value);
        } else return currentNode;

    }
}

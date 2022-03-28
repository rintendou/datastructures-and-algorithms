package binarysearchtree;

public class Node {
    Node left;
    Node right;
    int data;

    public Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }

    // Useless methods after making variables public. Using getters and setters was messing with my head too much.

    public int getData(Node node) {
        return node.data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getLeftChild(Node root) {
        root = root.left;
        return root;
    }

    public Node getRightChild(Node root) {
        root = root.right;
        return root;
    }

    public void setLeftChild(Node node, int data) {
        node.left = new Node(data);
    }

    public void setRightChild(Node node, int data) {
        node.right = new Node(data);
    }
}
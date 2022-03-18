package binarysearchtree;

public class Node {
    private Node left;
    private Node right;
    private int data;

    public Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }

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
}
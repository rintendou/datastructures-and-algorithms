package binarysearchtree;

import java.util.NoSuchElementException;

public class BinarySearchTree {
    Node root;

    public BinarySearchTree(int data) {
        root.setData(data);
    }

    public void insert(int val) {
        Node current = root;
        while (current != null) {
            
        }
    }

    public int getMin() { 
        if (root == null) { // Check if tree exists. Edge case.
            System.out.println("Tree is empty.");
            throw new NoSuchElementException();
        }

        Node current = root; // Temp pointer.
        while (current != null) { // Exclusively looping through left branch of tree.
            current = current.getLeftChild(current);
        }
        return current.getData(current); // java:S2259 error being thrown here, no clue why.
    }

    public int getMax() {
        if (root == null) {
            System.out.println("Tree is empty.");
            throw new NoSuchElementException();
        }

        Node current = root;
        while (current != root) {
            current = current.getRightChild(current);
        }
        return current.getData(current);
    }

    public int getHeight(Node node) {
        if (node == null) return 0; // Either the tree is empty or we reached past the leaf node.
        int left = getHeight(node.getLeftChild(node)); 
        int right = getHeight(node.getRightChild(node));

        int h; // Height of a node.
        if (left > right) {
            h = left + 1;
        } else {
            h = right + 1;
        }
        return h;
    }

    public boolean isBinarySearchTree(Node root, int min, int max) {
        if (root == null) return true; // Return true once we reach the end of a leaf. Will begin popping nodes off stack and return a truth value.
        if (root.getData(root) <= min || root.getData(root) > max) return false; // We set limits, min & max. If our root is less than our min, then we know that the node we are looking at should be in the left subtree, meaning it is not a BST. If our root is greater than our max, then we know that the node we are looking at should be in the right subtree, meaning that it is not a BST.
        return isBinarySearchTree(root.getLeftChild(root), min, root.getData(root)) && isBinarySearchTree(root.getRightChild(root), root.getData(root), max); // Recursive call, getting both left and right children
    }
}

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
            throw new NoSuchElementException();
        }

        Node current = root; // Temp pointer.
        while (current != null) { // Exclusively looping through left branch of tree.
            current = current.getLeftChild(current);
        }
        return current.getData(current); // java:S2259 error being thrown here, no clue why.
    }

    
}

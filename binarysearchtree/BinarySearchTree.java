package binarysearchtree;

import java.util.NoSuchElementException;

public class BinarySearchTree { // No dupes allowed.
    private Node root;

    public BinarySearchTree(int data) {
        root.setData(data);
    }

   /*  public void insert(int val) {
        Node current = root;
        while (current != null) {
            
        }
    } */

    public Node delete(Node root, int data) {
        if (root == null) return null; // If tree is empty, return itself (null)

        if (data < root.data) { // Going down the entire left side of tree, until condition is met.
            root.left = delete(root.left, data);
        } else if (data > root.data) { // Going down the entire right side of tree, until condition is met.
            root.right = delete(root.right, data);
        } else {
            if (root.left == null && root.right == null) { // Case 1: Node containing data we want to delete has no children.
                root = null;
                return root;
            } else if (root.left == null) { // Case 2: Node containing data has a single child.
                Node temp = root;
                root = root.right;
                temp = root;
                root
            } else if (root.right == null) { 
                root = getMax(root);
            }
        }
        return root;
    }

    public Node getMin(Node root) { 
        if (root == null) { // Check if tree exists. Edge case.
            System.out.println("Tree is empty.");
            throw new NoSuchElementException();
        }

        if (root.left == null & root.right == null) {
            return root;
        }

        Node current = root; // Temp pointer.
        while (current != null) { // Exclusively looping through left branch of tree.
            current = current.left;
        }
        return current; // java:S2259 error being thrown here, no clue why.
    }

    public Node getMax(Node root) {
        if (root == null) {
            System.out.println("Tree is empty.");
            throw new NoSuchElementException();
        }

        if (root.left == null & root.right == null) {
            return root;
        }

        Node current = root;
        while (current != null) {
            current = current.right;
        }
        return current;
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
        if (root.data <= min || root.data > max) return false; // We set limits, min & max. If our root is less than our min, then we know that the node we are looking at should be in the left subtree, meaning it is not a BST. If our root is greater than our max, then we know that the node we are looking at should be in the right subtree, meaning that it is not a BST.
        return isBinarySearchTree(root.left, min, root.data) && isBinarySearchTree(root.right, root.data, max); // Recursive call, getting both left and right children
    }
}

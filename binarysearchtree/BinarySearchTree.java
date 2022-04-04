package binarysearchtree;

import java.util.NoSuchElementException;

public class BinarySearchTree { // No dupes allowed.
    private Node root;
    private int count;

    public BinarySearchTree(Node root) {
        this.root = root;
    }

    public void insert(int data) {
        if (data < 0) {
            System.out.println("Positive numbers only.");
            return;
        }
        Node current = root;
        Node prev = root;

        if (root == null) { // If tree is empty
            root = new Node(data);
            return;
        }

        while (current != null) { // Traversal loop
            if (data < current.data) { // Go to left side of tree
                prev = current;
                current = current.left;
            } else if (data > current.data) { // Go to right side of tree
                prev = current;
                current = current.right;
            }
        }

        if (data < prev.data) prev.left = new Node(data); // Actual insertion at the end of the left tree.
        else if (data > prev.data) prev.right = new Node(data); // Actual insertion at the end of the right tree.
        count++;
    } 

    public Node delete(Node root, int data) { // Recursive method.
        if (root == null) return null; // If tree is empty, return itself (null)

        if (data < root.data) { // Going down the entire left side of tree, until condition is met.
            root.left = delete(root.left, data);
        } else if (data > root.data) { // Going down the entire right side of tree, until condition is met.
            root.right = delete(root.right, data);
        } else {
            if (root.left == null && root.right == null) { // Case 1: Node containing data we want to delete has no children.
                root = null;
                count--;
                return root;
            } else if (root.left == null) { // Case 2: Node containing data has a single child, Right child.
                Node temp = root;
                temp = temp.right;
                root = temp;
                temp = null;
            } else if (root.right == null) { // Case 2: Left Child.
                Node temp = root;
                temp = temp.left;
                root = temp;
                temp = null;
            } else { // Case 3: Node containing data has two children.
                Node temp = getMin(root.right);
                root.data = temp.data;
                root.right = delete(root.right, temp.data);
            }
        }
        count--;
        return root;
    }

    public int getNodeCount() {
        return count;
    }

    public Node getMin(Node root) { 
        if (root == null) { // Check if tree exists. Edge case.
            System.out.println("Tree is empty.");
            throw new NoSuchElementException();
        }

        if (root.left == null && root.right == null) {
            return root;
        }

        Node current = root; // Temp pointer.
        while (current != null) { // Exclusively looping through left branch of tree.
            current = current.left;
        }
        return current; // Fixed error.
    }

    public Node getMax(Node root) {
        if (root == null) {
            System.out.println("Tree is empty.");
            throw new NoSuchElementException();
        }

        if (root.left == null && root.right == null) {
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

    public void printValues(Node root) {
        Node current = root; // temp pointer
        if (current == null) return;
        printValues(current.left);
        System.out.println(current.data + " ");
        printValues(current.right);
    }

    public boolean isInTree(int data) {
        Node current = root; // temp pointer

        while (current.data != data) {
            if (data < current.data) {
                current = current.left;
            } else if (data > current.data) {
                current = current.right;
            } else {
                return true;
            }
        }
        return false;
    }

    public void deleteTree() {
        root = null; // This solution does not working is lower-level languages since they do not have an automatic garbage collector
    }

    public int getSuccessor(int data) {
        Node current = root; // Creating temp pointer

        while (current.data != data) { // Locating node containing data, referring to it as "data node"
            if (data < current.data) {
                current = current.left;
            } else if (data > current.data) {
                current = current.right;
            } else {
                if (current.right == null) return current.data; // If "data node" has no right children, then just return "data node".
                else {
                    return current.right.data;
                }
            }
        }
        return -1; // Not found.
    }
}

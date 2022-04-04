package binarysearchtree;

public class BinarySearchTreeTester {
    public static void main(String[] args) {
        Node root = new Node(20);
        BinarySearchTree tree = new BinarySearchTree(root);
        tree.insert(10);
        tree.insert(30);
        tree.insert(80);
        tree.insert(40);
        tree.insert(5);
        tree.insert(9);

        System.out.println("---------" + '\n' + "Printing current values of the tree: ");
        tree.printValues(root);

        System.out.println("---------");
        tree.delete(root, 30);
        System.out.println("Removing node containing value 30: ");
        tree.printValues(root);

        System.out.println("---------" + '\n' + "Returning # of nodes in tree: ");
        System.out.println(tree.getNodeCount()); // Not printing the correct thing, debugging.

    }
}

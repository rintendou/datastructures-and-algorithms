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

        System.out.println("---------" + '\n' + "Returning # of nodes in tree: ");
        System.out.println(tree.getNodeCount());

        System.out.println("---------");
        tree.delete(root, 30);
        System.out.println("Removing node containing value 30: ");
        tree.printValues(root);

        System.out.println("---------" + '\n' + "Returning # of nodes in tree: ");
        System.out.println(tree.getNodeCount());

        System.out.println("---------" + '\n' + "Is the tree a BST?: ");
        System.out.println(tree.isBinarySearchTree(root, 0, Integer.MAX_VALUE));
        
        System.out.println("---------" + '\n' + "Max value in the tree: ");
        System.out.println(tree.getMax(root));

        System.out.println("---------" + '\n' + "Minimum value in the tree: ");
        System.out.println(tree.getMin(root));

        System.out.println("---------" + '\n' + "Is a value in the BST?: ");
        System.out.println(tree.isInTree(5));

        System.out.println("---------" + '\n' + "Successor of node 'x': ");
        System.out.println(tree.getSuccessor(5));

        System.out.println("---------" + '\n' + "Deleting tree: ");
        tree.deleteTree(); // Does not work.
        tree.printValues(root);
    }
}

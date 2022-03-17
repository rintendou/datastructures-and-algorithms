package binarysearchtree;

public class BstNode {
    private BstNode left;
    private BstNode root;
    private BstNode right;
    private Object data;

    public BstNode getRoot() {
        return root;
    }

    public BstNode getRight() {
        return right;
    }

    public BstNode getLeft() {
        return left;
    }

    public Object getRootData() {
        return root.data;
    }
    
    public Object getLeftData() {
        return left.data;
    }

    public Object getRightData() {
        return right.data;
    }

    public void setLeftData(Object data) {
        left.data = data;
    }

    public void setRightData(Object data) {
        right.data = data;
    }
}
package tony.util;

public class ParentTreeNode {
    private int val;
    private ParentTreeNode left;
    private ParentTreeNode right;
    private ParentTreeNode parent;

    public ParentTreeNode(int val){
        this.val = val;
    }

    public ParentTreeNode(int val, ParentTreeNode parent){
        this.val = val;
        this.parent = parent;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public ParentTreeNode getLeft() {
        return left;
    }

    public void setLeft(ParentTreeNode left) {
        this.left = left;
    }

    public ParentTreeNode getRight() {
        return right;
    }

    public void setRight(ParentTreeNode right) {
        this.right = right;
    }

    public ParentTreeNode getParent() {
        return parent;
    }

    public void setParent(ParentTreeNode parent) {
        this.parent = parent;
    }
}

package tony.util;

public class BinarySearchTree {

    private ParentTreeNode root = null;

    public BinarySearchTree(){
    }
    
    public BinarySearchTree(int val){
        this.root = new ParentTreeNode(val);
    }

    public Integer getMin(){
        ParentTreeNode node = getMin(this.root);
        return null == node ? null : node.getVal();
    }

    private ParentTreeNode getMin(ParentTreeNode node){
        if (null == node){
            return null;
        }
        while (node.getLeft() != null){
            node = node.getLeft();
        }
        return node;
    }

    public Integer getMax(){
        ParentTreeNode node = getMax(this.root);
        return null == node ? null : node.getVal();
    }

    private ParentTreeNode getMax(ParentTreeNode node){
        if (null == node){
            return null;
        }
        while (node.getRight() != null){
            node = node.getRight();
        }
        return node;
    }

    /**
     * 查找
     *
     * @param key
     * @return
     */
    public ParentTreeNode search(int key){
        if (null == root){
            throw new RuntimeException("NULL Root");
        }

        ParentTreeNode current = root;
        while (current != null){
            if (current.getVal() == key){
                return current;
            } else if (current.getVal() > key){
                current = current.getLeft();
            } else {
                current = current.getRight();
            }
        }

        return null;
    }

    /**
     * 插入内容
     *
     * @param key
     * @return
     */
    public ParentTreeNode insert(int key){
        if (null == root){
            root = new ParentTreeNode(key);
            return root;
        } else {
            return insert(root, key);
        }
    }

    /**
     * 在指定节点下插入
     *
     * @param node
     * @param key
     * @return
     */
    public ParentTreeNode insert(ParentTreeNode node, int key){
        assertChild(node);
        if (null != search(key)){
            throw new IllegalStateException("Duplicate value");
        }
        return insertInternal(node, key);
    }

    private ParentTreeNode insertInternal(ParentTreeNode node, int key){
        if (node.getVal() > key){
            if (null == node.getLeft()){
                ParentTreeNode newone = new ParentTreeNode(key, node);
                node.setLeft(newone);
                return newone;
            } else {
                return insertInternal(node.getLeft(), key);
            }
        } else {
            if (null == node.getRight()){
                ParentTreeNode newone = new ParentTreeNode(key, node);
                node.setRight(newone);
                return newone;
            } else {
                return insertInternal(node.getRight(), key);
            }
        }
    }

    public ParentTreeNode delete(int key){
        ParentTreeNode node = search(key);
        return null == node ? null : deleteInternal(node);
    }

    private ParentTreeNode deleteInternal(ParentTreeNode node){
        if (node.getLeft() == null && node.getRight() == null){
            // 叶子节点
            if (null == node.getParent()){
                this.root = null;
            } else if (node.getParent().getLeft() == node) {
                node.getParent().setLeft(null);
            } else {
                node.getParent().setRight(null);
            }
        } else if (node.getLeft() == null) {
            // 只有右子节点
            transplant(node, node.getRight());
        } else if (node.getRight() == null) {
            // 只有左子节点
            transplant(node, node.getLeft());
        } else {
            // 同时有两个子节点
            ParentTreeNode successor = successor(node);
            if (node.getRight() == successor){
                // 右子节点没有左节点
                transplant(node, successor);
                successor.setLeft(node.getLeft());
                successor.getLeft().setParent(successor);
            } else {
                ParentTreeNode sRight = successor.getRight();
                ParentTreeNode sParent = successor.getParent();
                ParentTreeNode nLeft = node.getLeft();
                ParentTreeNode nRight = node.getRight();

                sParent.setLeft(sRight);
                if (null != sRight) {
                    sRight.setParent(sParent);
                }

                transplant(node, successor);

                successor.setLeft(nLeft);
                nLeft.setParent(successor);

                successor.setRight(nRight);
                nRight.setParent(successor);
            }
        }

        return isolate(node);
    }

    // 使用y替换x
    private void transplant(ParentTreeNode x, ParentTreeNode y){
        if (x == root){
            root = y;
        } else {
            if (x.getParent().getRight() == x) {
                x.getParent().setRight(y);
                y.setParent(x.getParent());
            } else {
                x.getParent().setLeft(y);
                y.setParent(x.getParent());
            }
        }
    }

    private ParentTreeNode isolate(ParentTreeNode node){
        node.setParent(null);
        node.setLeft(null);
        node.setRight(null);
        return node;
    }

    /**
     * 获取取第一个比输入节点小的节点
     *
     * @param node
     * @return
     */
    private ParentTreeNode predecessor(ParentTreeNode node){
        assertChild(node);
        if (null != node.getLeft()){
            return getMax(node.getLeft());
        } else {
            int judge = node.getVal();
            while (null != node && node.getVal() >= judge){
                node = node.getParent();
            }
            return node;
        }
    }

    /**
     * 获取第一个比输入节点大的节点
     *
     * @param node
     * @return
     */
    private ParentTreeNode successor(ParentTreeNode node){
        assertChild(node);
        if (null != node.getRight()){
            return getMin(node.getLeft());
        } else {
            int judge = node.getVal();
            while (null != node && node.getVal() <= judge){
                node = node.getParent();
            }
            return node;
        }
    }

    private void assertChild(ParentTreeNode node){
        if (null == this.root){
            throw new RuntimeException("NULL Root");
        }
        if (null == node){
            throw new RuntimeException("NULL Input");
        }
        while (node.getParent() != null){
            node = node.getParent();
        }
        if (!root.equals(node)){
            throw new IllegalStateException("Not a child ParentTreeNode");
        }
    }
}

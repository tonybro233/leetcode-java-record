package tony.alg;

import java.util.List;

/**
 * N叉树前序遍历
 */
public class Preorder {

    public void go(Node root){
        foo(root);
    }

    private void foo(Node node){
        if (null == node){
            return;
        }
        System.out.println(node.val);
        for (Node ea : node.children){
            foo(ea);
        }
    }
}


class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};

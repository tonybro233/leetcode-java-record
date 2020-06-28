package tony.sword_to_offer;

// 36. 二叉搜索树与双向链表
// 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。
// 要求不能创建任何新的节点，只能调整树中节点指针的指向。

// 特别地，我们希望可以就地完成转换操作。当转化完成以后，
// 树中节点的左指针需要指向前驱，树中节点的右指针需要指向后继。
// 还需要返回链表中的第一个节点的指针。

public class _36_bst_to_deque {

    private Node pre = null, head = null;

    // 没想到的方法，直接中序遍历，维护前一个节点
    public Node treeToDoublyList(Node root) {
        if (null == root) {
            return null;
        }
        dfs(root);
        head.left = pre;
        pre.right = head;
        return head;
    }

    private void dfs(Node node) {
        if (null == node) {
            return;
        }

        dfs(node.left);
        if (null == pre) {
            head = node;
        } else {
            pre.right = node;
        }
        node.left = pre;

        pre = node;
        dfs(node.right);
    }


    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    };

}

package tony.util;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * TreeNode is the node of a binary tree.
 *
 *     val
 *     / \
 *  left right
 */
public class TreeNode {

    public TreeNode left;

    public TreeNode right;

    public int val;

    // create node with a specific value
    public TreeNode(int x) {
        val = x;
    }

    /**
     * Serialization: print the nodes in BFS order
     */
    @Override
    public String toString() {
        return serialize().toString();
    }

    private List<List<Integer>> serialize() {
        List<List<Integer>> res = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        deque.addLast(this);
        int colcount = 1;
        boolean hasval = true;
        TreeNode obj = new TreeNode(0);
        while (hasval) {
            hasval = false;
            List<Integer> vals = new ArrayList<>();
            for (int i = 0; i < colcount; i++) {
                TreeNode node = deque.pollFirst();
                if (obj == node) {
                    vals.add(null);
                    deque.addLast(obj);
                    deque.addLast(obj);
                } else {
                    vals.add(node.val);
                    if (null != node.left || null != node.right) {
                        hasval = true;
                    }
                    if (null != node.left) {
                        deque.addLast(node.left);
                    } else {
                        deque.addLast(obj);
                    }
                    if (null != node.right) {
                        deque.addLast(node.right);
                    } else {
                        deque.addLast(obj);
                    }
                }
            }
            res.add(vals);
            colcount <<= 1;
        }
        return res;
    }

    public static void prettyPrintTree(TreeNode node) {
        prettyPrintTree(node, "", true);
    }

    public static void prettyPrintTree(TreeNode node, String prefix, boolean isLeft) {
        if (node == null) {
            System.out.println("Empty tree");
            return;
        }

        if (node.right != null) {
            prettyPrintTree(node.right, prefix + (isLeft ? "│   " : "    "), false);
        }

        System.out.println(prefix + (isLeft ? "└── " : "┌── ") + node.val);

        if (node.left != null) {
            prettyPrintTree(node.left, prefix + (isLeft ? "    " : "│   "), true);
        }
    }

}

package tony.util;

import java.util.ArrayList;
import java.util.List;

/**
 * TreeLinkNode is a binary tree with next pointer.
 * For example, a perfect binary tree of 7 TreeLinkedNode looks like,
 *
 *           1 -> NULL
 *         /  \
 *        2 -> 3 -> NULL
 *       / \  / \
 *      4->5->6->7 -> NULL
 *
 * Related problem:
 * Problem #116 - Populating Next Right Pointers in Each Node
 *
 */
public class TreeLinkNode {

    public int val;

    public TreeLinkNode left;

    public TreeLinkNode right;

    public TreeLinkNode next;

    /**
     * Constructor
     * @param x value of this node.
     */
    public TreeLinkNode(int x) {
        val = x;
    }

    /**
     * Serialization (in BFS order)
     */
    @Override
    public String toString() {
        return bfs().toString();
    }


    /**============================== 【private members】 ============================== */

    /** parse the tree in BFS order */
    private List<List<Integer>> bfs() {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<TreeLinkNode> buffer = new ArrayList<>();
        buffer.add(this);
        while (!buffer.isEmpty()) {
            List<Integer> thisLevel = new ArrayList<Integer>();
            int size = buffer.size();
            for (int i = 0; i < size; i++) {
                TreeLinkNode node = buffer.remove(0);
                if (node != null) {
                    thisLevel.add(node.val);
                    buffer.add(node.left);
                    buffer.add(node.right);
                } else {
                    thisLevel.add(null);
                }
            }
            if (thisLevel.isEmpty()) {
                continue;
            }
            for (Integer n : thisLevel) { // eliminate the bottom row with all null nodes
                if (n != null) {
                    res.add(thisLevel);
                    break;
                }
            }
        }
        return res;
    }

}

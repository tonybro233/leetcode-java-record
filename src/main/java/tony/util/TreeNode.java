package tony.util;

import java.util.ArrayList;
import java.util.List;

/**
 * TreeNode is the node of a binary tree.
 *
 *     val
 *     / \
 *  left right
 *
 * @author Wei SHEN
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
        return bfs().toString();
    }

    /**
     * Parse the tree in BFS order
     * @return List of Integer
     *
     * For example, given the following tree,
     *      a
     *     / \
     *    b  null
     * output = [[a],[b,null]]
     * null node will be listed in the output
     */
    private List<List<Integer>> bfs() {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<TreeNode> buffer = new ArrayList<>();
        buffer.add(this);
        while (!buffer.isEmpty()) {
            List<Integer> line = new ArrayList<>();
            int size = buffer.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = buffer.remove(0);
                if (node == null) {
                    line.add(null);
                } else {
                    line.add(node.val);
                    buffer.add(node.left);
                    buffer.add(node.right);
                }
            }
            if (line.isEmpty()) {
                continue;
            }
            for (Integer n : line) { // ignore the bottom line with all null nodes
                if (n != null) {
                    res.add(line);
                }
                break;
            }
        }
        return res;
    }

}

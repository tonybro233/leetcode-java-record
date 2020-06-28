package tony.sword_to_offer;

import tony.util.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

// 37. 序列化二叉树
// 请实现两个函数，分别用来序列化和反序列化二叉树。
//
// 示例: 
// 你可以将以下二叉树：
//     1
//    / \
//   2   3
//      / \
//     4   5
//
// 序列化为 "[1,2,3,null,null,4,5]"

public class _37_codec_tree {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (null == root) {
            return "null";
        }
        return root.val + "," + serialize(root.left) + "," + serialize(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (null == data) {
            throw new IllegalArgumentException();
        }
        String[] tokens = data.split(",");
        Deque<String> queue = new ArrayDeque<>(tokens.length);
        for (String token : tokens) {
            queue.addLast(token);
        }
        return de(queue);
    }

    private TreeNode de(Deque<String> queue) {
        String token = queue.pollFirst();
        if ("null".equals(token)) {
            return null;
        }
        TreeNode current = new TreeNode(Integer.parseInt(token));
        current.left = de(queue);
        current.right = de(queue);
        return current;
    }

}

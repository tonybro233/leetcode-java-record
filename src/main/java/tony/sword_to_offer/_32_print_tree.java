package tony.sword_to_offer;

import tony.util.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

// 32 - I. 从上到下打印二叉树
// 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
//
// 例如:
// 给定二叉树: [3,9,20,null,null,15,7],
//     3
//    / \
//   9  20
//     /  \
//    15   7
// 返回：
// [3,9,20,15,7]

public class _32_print_tree {

    public int[] levelOrder(TreeNode root) {
        if (null == root) {
            return new int[0];
        }
        Deque<TreeNode> deque = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        deque.addLast(root);

        while (null != deque.peekFirst()) {
            TreeNode node = deque.pollFirst();
            result.add(node.val);
            if (null != node.left) {
                deque.addLast(node.left);
            }
            if (null != node.right) {
                deque.addLast(node.right);
            }
        }

        int[] array = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            array[i] = result.get(i);
        }

        return array;
    }

}

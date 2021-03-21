package tony.leetcode.feature.bfs;

import tony.util.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

// 107. 二叉树的层序遍历 II
// 给定一个二叉树，返回其节点值自底向上的层序遍历。
// （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
//
// 例如：
// 给定二叉树 [3,9,20,null,null,15,7],
//
//     3
//    / \
//   9  20
//     /  \
//    15   7
// 返回其自底向上的层序遍历为：
//
// [
//   [15,7],
//   [9,20],
//   [3]
// ]

public class Binary_Tree_Level_Order_Traversal_II {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> result = new LinkedList<>();
        if (null == root) {
            return result;
        }

        Deque<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        List<Integer> floor = new ArrayList<>();
        int current = 1, next = 0;
        while (!queue.isEmpty()) {
            TreeNode node = queue.pollFirst();
            floor.add(node.val);
            if (null != node.left) {
                queue.addLast(node.left);
                next++;
            }
            if (null != node.right) {
                queue.addLast(node.right);
                next++;
            }
            if (--current == 0) {
                current = next;
                next = 0;
                result.addFirst(floor);
                floor = new ArrayList<>();
            }
        }

        return result;
    }

}

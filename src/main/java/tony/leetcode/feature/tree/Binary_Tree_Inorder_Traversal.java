package tony.leetcode.feature.tree;

import tony.util.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

// 94. 二叉树的中序遍历
// 给定一个二叉树，返回它的中序 遍历。
//
// 示例:
// 输入: [1,null,2,3]
//    1
//     \
//      2
//     /
//    3
// 输出: [1,3,2]

// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？

public class Binary_Tree_Inorder_Traversal {

    // 非递归
    public List<Integer> inorderTraversal2(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        if (null == root) {
            return result;
        }
        TreeNode last = null;
        stack.addLast(root);
        while (null != stack.peekLast()) {
            TreeNode node = stack.peekLast();
            if (null == node.left && null == node.right) {
                // 叶子节点
                result.add(node.val);
                last = stack.pollLast();
                continue;
            }
            if (null != node.right && last == node.right) {
                // 右节点返回
                last = stack.pollLast();
                continue;
            }
            if (null == node.left) {
                // 只有右节点
                result.add(node.val);
                stack.addLast(node.right);
            } else {
                if (last != node.left) {
                    // 左节点入队
                    stack.addLast(node.left);
                } else {
                    // 左节点返回
                    result.add(node.val);
                    if (null != node.right) {
                        stack.addLast(node.right);
                    } else {
                        last = stack.pollLast();
                    }
                }
            }
        }
        return result;
    }

    // 递归
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        go(root, result);
        return result;
    }

    private void go(TreeNode node, List<Integer> result) {
        if (null == node) {
            return;
        }
        go(node.left, result);
        result.add(node.val);
        go(node.right, result);
    }
}

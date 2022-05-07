package tony.leetcode.feature.tree;

import tony.util.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

// 144. 二叉树的前序遍历
// 给定一个二叉树，返回它的 前序 遍历。
//
//  示例:
// 输入: [1,null,2,3]
//    1
//     \
//      2
//     /
//    3
//
// 输出: [1,2,3]
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？

public class Binary_Tree_Preorder_Traversal {

    // 非递归
    public List<Integer> preorderTraversal2(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        if (null == root) {
            return result;
        }
        TreeNode last = null;
        stack.addLast(root);
        result.add(root.val);
        while (null != stack.peekLast()) {
            TreeNode node = stack.peekLast();
            if (null == node.left && null == node.right) {
                // 叶子节点
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
                stack.addLast(node.right);
                result.add(node.right.val);
            } else {
                if (last != node.left) {
                    // 左节点入队
                    stack.addLast(node.left);
                    result.add(node.left.val);
                } else {
                    // 左节点返回
                    if (null != node.right) {
                        stack.addLast(node.right);
                        result.add(node.right.val);
                    } else {
                        last = stack.pollLast();
                    }
                }
            }
        }
        return result;
    }

    // 递归
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        go(root, result);
        return result;
    }

    private void go(TreeNode node, List<Integer> result) {
        if (null == node) {
            return;
        }
        result.add(node.val);
        go(node.left, result);
        go(node.right, result);
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        n1.right = n2;
        n2.left = n3;
        List<Integer> list = new Binary_Tree_Preorder_Traversal().preorderTraversal2(n1);
        System.out.println(list);
    }
}
